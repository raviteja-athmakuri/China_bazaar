package ECommerce.ChinaBazaarECommerce.Controller;

import ECommerce.ChinaBazaarECommerce.Entity.Product;
import ECommerce.ChinaBazaarECommerce.Exception.SellerNotFoundException;
import ECommerce.ChinaBazaarECommerce.RequestDto.ProductRequestDto;
import ECommerce.ChinaBazaarECommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        try {
            productService.addProduct(productRequestDto);
        } catch (SellerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Product Added Successfully",HttpStatus.ACCEPTED);
    }

}
