package ECommerce.ChinaBazaarECommerce.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional
@Builder
public class CardResponseDto {

    private String name;
    List<CardDto> cardDtoList;
}
