package ECommerce.ChinaBazaarECommerce.Convertor;

import ECommerce.ChinaBazaarECommerce.Entity.Customer;
import ECommerce.ChinaBazaarECommerce.RequestDto.CustomerRequestDto;
import ECommerce.ChinaBazaarECommerce.ResponseDto.CustomerResponseDto;

public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .age(customerRequestDto.getAge())
                .name(customerRequestDto.getName())
                .email(customerRequestDto.getEmail())
                .mobileNo(customerRequestDto.getMobNo())
                .build();
    }
    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}
