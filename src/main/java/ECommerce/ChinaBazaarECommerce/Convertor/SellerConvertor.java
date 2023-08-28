package ECommerce.ChinaBazaarECommerce.Convertor;

import ECommerce.ChinaBazaarECommerce.Entity.Seller;
import ECommerce.ChinaBazaarECommerce.RequestDto.SellerRequestDTo;
import ECommerce.ChinaBazaarECommerce.ResponseDto.SellerResponseDto;

public class SellerConvertor {

    public static Seller sellerRequestDtoToSeller(SellerRequestDTo sellerRequestDTo){

       return Seller.builder()
                .name(sellerRequestDTo.getName())
                .email(sellerRequestDTo.getEmail())
                .panNo(sellerRequestDTo.getPanNo())
                .mobileNo(sellerRequestDTo.getMobileNo())
                .build();

    }
    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .name(seller.getName())
                .mobileNo(seller.getMobileNo())
                .build();
    }
}
