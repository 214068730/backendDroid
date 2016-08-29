package droid_backend.repository;

import droid_backend.domain.shop.Orderline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Siraaj on 08/14/2016.
 */
@Repository
public interface OrderlineRepository extends CrudRepository<Orderline,Long> {
}
