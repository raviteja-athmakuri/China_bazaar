package ECommerce.ChinaBazaarECommerce.Service;

import ECommerce.ChinaBazaarECommerce.Convertor.CustomerConvertor;
import ECommerce.ChinaBazaarECommerce.Entity.Cart;
import ECommerce.ChinaBazaarECommerce.Entity.Customer;
import ECommerce.ChinaBazaarECommerce.Repository.CustomerRepository;
import ECommerce.ChinaBazaarECommerce.RequestDto.CustomerRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer= CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);
        Cart cart=new Cart();
        cart.setTotal(0);
        customer.setCart(cart);
        cart.setCustomer(customer);
        customerRepository.save(customer);

        CustomerResponseDto customerResponseDto=CustomerConvertor.CustomerToCustomerResponseDto(customer);
        return customerResponseDto;

    }
}
