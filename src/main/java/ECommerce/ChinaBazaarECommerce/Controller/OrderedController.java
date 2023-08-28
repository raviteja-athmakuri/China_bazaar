package ECommerce.ChinaBazaarECommerce.Controller;

import ECommerce.ChinaBazaarECommerce.RequestDto.OrderRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.OrderResponseDto;
import ECommerce.ChinaBazaarECommerce.Service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderedController {

    @Autowired
    OrderedService orderedService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){

        OrderResponseDto orderResponseDto;
        try{
            orderResponseDto=orderedService.placeOrder(orderRequestDto);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);

    }
}
