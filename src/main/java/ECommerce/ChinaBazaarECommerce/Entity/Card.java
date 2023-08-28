package ECommerce.ChinaBazaarECommerce.Entity;

import ECommerce.ChinaBazaarECommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cardNo;
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private int cvv;

    @ManyToOne
    @JoinColumn
    Customer customer;
}
