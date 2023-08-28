package ECommerce.ChinaBazaarECommerce.Convertor;

import ECommerce.ChinaBazaarECommerce.Entity.Product;
import ECommerce.ChinaBazaarECommerce.Enum.ProductStatus;
import ECommerce.ChinaBazaarECommerce.RequestDto.ProductRequestDto;

public class ProductConverter {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productType(productRequestDto.getProductType())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
}
