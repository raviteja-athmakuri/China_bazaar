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
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mobileNo;
    private String email;
    private int age;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Card> cardArrayList= new ArrayList<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Ordered> orderedList= new ArrayList<>();




}
