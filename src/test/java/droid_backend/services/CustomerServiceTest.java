package droid_backend.services;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.factory.AddressFactory;
import droid_backend.repository.CustomerRepository;
import droid_backend.services.Impl.CustomerServceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by Siraaj on 08/17/2016.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    
    @Autowired
    private CustomerServceImpl service;

    @Test
    public void testCreateCustomer() throws Exception {
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Customer customer = new Customer.CustomerBuild()
                .custCode(0L)
                .custName("Shahiem")
                .address(customerAddress)
                .build();
        Customer recordCustomer = service.create(customer);
        Assert.assertNotNull(recordCustomer);
    }

    @Test(dependsOnMethods = "testCreateCustomer")
    public void testReadAll() throws Exception {
        Iterable<Customer> customers =  service.readAll();
        Assert.assertNotNull(customers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdate() throws Exception {
        Customer customer = service.readById(1L);
        Customer updateCustomer = new Customer.CustomerBuild()
                .copy(customer)
                .custName("SiKash")
                .build();
        Customer updatedCustomerRecord =service.update(updateCustomer);
        Assert.assertEquals("SiKash",updatedCustomerRecord.getCustName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDeleteCustomer() throws Exception {
        Customer customer = service.readById(2L);
        if(customer != null)
        {
            Assert.assertNotNull(customer);
            service.delete(customer);
            Customer deletedCustomer = service.readById(2L);
            Assert.assertNull(deletedCustomer);
        }
    }
}
