package ECommerce.ChinaBazaarECommerce.Controller;


import ECommerce.ChinaBazaarECommerce.RequestDto.CustomerRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CustomerResponseDto;
import ECommerce.ChinaBazaarECommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        return customerService.addCustomer(customerRequestDto);

    }
}
