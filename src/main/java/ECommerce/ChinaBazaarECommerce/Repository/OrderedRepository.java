package ECommerce.ChinaBazaarECommerce.Repository;

import ECommerce.ChinaBazaarECommerce.Entity.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {
}
