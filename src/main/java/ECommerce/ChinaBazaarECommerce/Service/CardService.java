package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Convertor.CardConverter;
import ECommerce.ChinaBazaarECommerce.Entity.Card;
import ECommerce.ChinaBazaarECommerce.Entity.Customer;
import ECommerce.ChinaBazaarECommerce.Exception.CustomerNotFoundException;
import ECommerce.ChinaBazaarECommerce.Repository.CustomerRepository;
import ECommerce.ChinaBazaarECommerce.RequestDto.CardRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CardDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Card card = CardConverter.cardRequestDtotocard(cardRequestDto);
        Customer customer;
        try{
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw  new CustomerNotFoundException("Invalid Customer Id ");
        }

        card.setCustomer(customer);

        customer.getCardArrayList().add(card);
        customerRepository.save(customer);

        CardResponseDto cardResponseDto = new CardResponseDto();

        cardResponseDto.setName(customer.getName());
        List<CardDto> arr = new ArrayList<>();
        List<Card>allCards= customer.getCardArrayList();
        for(Card c : allCards){
            CardDto cardDto= new CardDto();
            cardDto.setCardNo(c.getCardNo());
            cardDto.setCardType(c.getCardType());
            arr.add(cardDto);
        }
        cardResponseDto.setCardDtoList(arr);
        return cardResponseDto;
    }
}
