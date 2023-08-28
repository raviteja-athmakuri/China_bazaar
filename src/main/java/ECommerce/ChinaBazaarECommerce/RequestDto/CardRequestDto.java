package ECommerce.ChinaBazaarECommerce.RequestDto;

import ECommerce.ChinaBazaarECommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional

public class CardRequestDto {

    private String cardNo;
    private CardType cardType;
    private int cvv;

    private int customerId;

}
