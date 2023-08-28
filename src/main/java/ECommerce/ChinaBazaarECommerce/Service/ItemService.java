package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Entity.Item;
import ECommerce.ChinaBazaarECommerce.Entity.Product;
import ECommerce.ChinaBazaarECommerce.Exception.ProductNotFoundException;
import ECommerce.ChinaBazaarECommerce.Repository.ItemRepository;
import ECommerce.ChinaBazaarECommerce.Repository.ProductRepository;
import ECommerce.ChinaBazaarECommerce.ResponseDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;

   public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {

       Product product;

       try{
           product=productRepository.findById(productId).get();
       }catch(Exception e){
           throw new ProductNotFoundException("Invalid product Id");
       }

       Item item= Item.builder()
               .requiredQuantity(0)
               .product(product)
               .build();

       product.setItem(item);

       productRepository.save(product);

       ItemResponseDto itemResponseDto=ItemResponseDto.builder()
               .price(product.getPrice())
               .productName(product.getName())
               .productStatus(product.getProductStatus())
               .productType(product.getProductType())
               .build();

       return itemResponseDto;
   }
}
