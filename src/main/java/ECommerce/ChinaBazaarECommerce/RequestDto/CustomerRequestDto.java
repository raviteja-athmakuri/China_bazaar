package ECommerce.ChinaBazaarECommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerRequestDto {

    private String name;

    private String mobNo;

    private String email;

    private int age;
}
