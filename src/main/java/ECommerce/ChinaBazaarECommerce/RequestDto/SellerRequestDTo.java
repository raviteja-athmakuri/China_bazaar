package ECommerce.ChinaBazaarECommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional

public class SellerRequestDTo {

    private String name;
    private String mobileNo;
    private String email;
    private String panNo;
}
