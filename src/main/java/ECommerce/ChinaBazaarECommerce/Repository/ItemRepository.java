package ECommerce.ChinaBazaarECommerce.Repository;

import ECommerce.ChinaBazaarECommerce.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
