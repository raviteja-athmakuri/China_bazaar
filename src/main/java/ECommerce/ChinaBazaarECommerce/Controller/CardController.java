package ECommerce.ChinaBazaarECommerce.Controller;


import ECommerce.ChinaBazaarECommerce.Entity.Customer;
import ECommerce.ChinaBazaarECommerce.Exception.CustomerNotFoundException;
import ECommerce.ChinaBazaarECommerce.RequestDto.CardRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CardResponseDto;
import ECommerce.ChinaBazaarECommerce.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        try{
             return cardService.addCard(cardRequestDto);

        }catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id ");
        }

    }
}
