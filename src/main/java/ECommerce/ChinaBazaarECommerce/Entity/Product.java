package ECommerce.ChinaBazaarECommerce.Entity;

import ECommerce.ChinaBazaarECommerce.Enum.ProductStatus;
import ECommerce.ChinaBazaarECommerce.Enum.ProductType;
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

public class Product {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private int quantity;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    Item item;
}
