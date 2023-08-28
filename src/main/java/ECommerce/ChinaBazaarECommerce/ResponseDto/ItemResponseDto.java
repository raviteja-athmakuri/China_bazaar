package ECommerce.ChinaBazaarECommerce.ResponseDto;

import ECommerce.ChinaBazaarECommerce.Enum.ProductStatus;
import ECommerce.ChinaBazaarECommerce.Enum.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {

    private String productName;
    private int price;

    private ProductType productType;

    private ProductStatus productStatus;
}
