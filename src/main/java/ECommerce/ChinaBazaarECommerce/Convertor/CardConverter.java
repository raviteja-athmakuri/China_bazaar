package ECommerce.ChinaBazaarECommerce.Convertor;

import ECommerce.ChinaBazaarECommerce.Entity.Card;
import ECommerce.ChinaBazaarECommerce.RequestDto.CardRequestDto;

public class CardConverter {

    public static Card cardRequestDtotocard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();
    }
}
