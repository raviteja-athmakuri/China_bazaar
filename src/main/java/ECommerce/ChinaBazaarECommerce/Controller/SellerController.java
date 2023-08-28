package ECommerce.ChinaBazaarECommerce.Controller;

import ECommerce.ChinaBazaarECommerce.RequestDto.SellerRequestDTo;
import ECommerce.ChinaBazaarECommerce.ResponseDto.SellerResponseDto;
import ECommerce.ChinaBazaarECommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/addseller")
    public SellerResponseDto addSeller(@RequestBody SellerRequestDTo sellerRequestDTo){
        return sellerService.addSeller(sellerRequestDTo);
    }
}
