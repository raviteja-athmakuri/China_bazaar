package ECommerce.ChinaBazaarECommerce.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional
@Builder

public class SellerResponseDto {
    private String name;
    private String mobileNo;
}
