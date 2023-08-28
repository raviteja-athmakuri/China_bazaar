package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Convertor.SellerConvertor;
import ECommerce.ChinaBazaarECommerce.Entity.Seller;
import ECommerce.ChinaBazaarECommerce.Repository.SellerRepository;
import ECommerce.ChinaBazaarECommerce.RequestDto.SellerRequestDTo;
import ECommerce.ChinaBazaarECommerce.ResponseDto.SellerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDTo sellerRequestDTo){
        Seller seller= SellerConvertor.sellerRequestDtoToSeller(sellerRequestDTo);

        sellerRepository.save(seller);


        SellerResponseDto sellerResponseDto= SellerConvertor.sellerToSellerResponseDto(seller);

        return sellerResponseDto;


    }
}
