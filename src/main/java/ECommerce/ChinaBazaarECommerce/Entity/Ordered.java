package ECommerce.ChinaBazaarECommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //Getter+Setter+Additional
@Builder

public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date orderedDate;

    private int totalCost;

    private int deliveryCharge;

    private String cardUsedForPayment;

    @OneToMany(mappedBy = "ordered",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;
}
