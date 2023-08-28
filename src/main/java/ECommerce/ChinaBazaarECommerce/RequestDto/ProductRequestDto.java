package ECommerce.ChinaBazaarECommerce.RequestDto;

import ECommerce.ChinaBazaarECommerce.Enum.ProductStatus;
import ECommerce.ChinaBazaarECommerce.Enum.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional

public class ProductRequestDto {

    private int sellerId;
    private String name;
    private int price;
    private int quantity;
    private ProductType productType;

}
