package droid_backend.repository;

import droid_backend.domain.shop.ShopProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Siraaj on 08/14/2016.
 */


@Repository
public interface SalesRepository extends CrudRepository<ShopProcess,Long> {
}
