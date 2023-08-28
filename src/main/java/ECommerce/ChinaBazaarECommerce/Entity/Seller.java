package ECommerce.ChinaBazaarECommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional
@Table(name = "seller")
@Builder

public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String mobileNo;
    private String panNo;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products= new ArrayList<>();
}
