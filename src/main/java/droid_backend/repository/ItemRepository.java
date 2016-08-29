package droid_backend.repository;

import droid_backend.domain.shop.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Siraaj on 08/13/2016.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
}
