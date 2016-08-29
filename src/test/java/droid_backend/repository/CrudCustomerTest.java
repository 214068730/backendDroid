package droid_backend.repository;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.domain.shop.Item;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.CustomerFactory;
import droid_backend.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/08/2016.
 */


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudCustomerTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private CustomerRepository repo;


    @Test
    public void testCreate() throws Exception {

        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);
        Customer newCustoemr =repo.save(customer);
         Assert.assertNotNull(newCustoemr);

        //repo.delete(2L);

    }
}
