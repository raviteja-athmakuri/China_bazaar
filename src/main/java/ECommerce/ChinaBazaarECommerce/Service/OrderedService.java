package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Entity.*;
import ECommerce.ChinaBazaarECommerce.Enum.ProductStatus;
import ECommerce.ChinaBazaarECommerce.Exception.CustomerNotFoundException;
import ECommerce.ChinaBazaarECommerce.Exception.ProductNotFoundException;
import ECommerce.ChinaBazaarECommerce.Repository.CustomerRepository;
import ECommerce.ChinaBazaarECommerce.Repository.ProductRepository;
import ECommerce.ChinaBazaarECommerce.RequestDto.OrderRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.ItemResponseDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemService itemService;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {

        Customer customer;
        try{
            customer=customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }catch(Exception e){
            throw new CustomerNotFoundException("Invalid customer Id");
        }

        Product product;
        try{
            product=productRepository.findById(orderRequestDto.getProductId()).get();
        }catch(Exception e){
            throw new ProductNotFoundException("Invalid product id");
        }

        if(product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new Exception("Sorry! required quantity is not available");
        }
       //To order we should view the item first
        ItemResponseDto itemResponseDto=itemService.viewItem(orderRequestDto.getProductId());
        Item item=product.getItem();

        int totalCost= orderRequestDto.getRequiredQuantity()* product.getQuantity();
        int deliveryCharge=0;
        if(totalCost<500)
            deliveryCharge=50;

        totalCost+=deliveryCharge;
        //prepare order
        Ordered ordered=Ordered.builder()
                .totalCost(totalCost)
                .deliveryCharge(deliveryCharge)
                .customer(customer)
                .build();

        ordered.getItemList().add(item);

        Card card=customer.getCardArrayList().get(0);

        String cardUsed="";

        int len=card.getCardNo().length();
        for(int i=0;i<len-4;i++){
            cardUsed+='X';
        }
        cardUsed+=card.getCardNo().substring(len-4);

        ordered.setCardUsedForPayment(cardUsed);

        //update customers current order list
        customer.getOrderedList().add(ordered);

        //update the quantity of product left in warehouse
        int leftQuantity=product.getQuantity()- orderRequestDto.getRequiredQuantity();
        product.setQuantity(leftQuantity);
        if(leftQuantity==0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }

        //update item
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setOrdered(ordered);

        customerRepository.save(customer);
        productRepository.save(product);

        //prepare response Dto
        OrderResponseDto orderResponseDto=OrderResponseDto.builder()
                .productName(product.getName())
                .orderDate(ordered.getOrderedDate())
                .itemPrice(product.getPrice())
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .totalCost(ordered.getTotalCost())
                .deliveryCost(ordered.getDeliveryCharge())
                .cardUsedForPayement(ordered.getCardUsedForPayment())
                .build();

        return orderResponseDto;

    }

}
