package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Convertor.ProductConverter;
import ECommerce.ChinaBazaarECommerce.Entity.Product;
import ECommerce.ChinaBazaarECommerce.Entity.Seller;
import ECommerce.ChinaBazaarECommerce.Exception.SellerNotFoundException;
import ECommerce.ChinaBazaarECommerce.Repository.ProductRepository;
import ECommerce.ChinaBazaarECommerce.Repository.SellerRepository;
import ECommerce.ChinaBazaarECommerce.RequestDto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;
    public void addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);
        Seller seller;
        try{
           seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw  new SellerNotFoundException("Invalid Seller Id...");
        }

        product.setSeller(seller);

        seller.getProducts().add(product);
        sellerRepository.save(seller);
    }
}
