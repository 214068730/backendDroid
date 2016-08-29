package droid_backend.repository;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.shop.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Siraaj on 08/03/2016.
 */



@Repository
public interface CustomerRepository  extends CrudRepository<Customer,Long>  {
}
