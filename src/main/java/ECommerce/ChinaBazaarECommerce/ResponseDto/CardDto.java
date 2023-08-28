package ECommerce.ChinaBazaarECommerce.ResponseDto;

import ECommerce.ChinaBazaarECommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional

public class CardDto {

    private String cardNo;
    private CardType cardType;
}
