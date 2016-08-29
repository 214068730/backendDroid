package droid_backend.api;

import droid_backend.App;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.factory.AddressFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Siraaj on 08/20/2016.
 */

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CustomerControllerTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testCreate(){
        String URI =  "http://localhost:8080/shop";
        RestTemplate restTemplate = new RestTemplate();
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Customer customer = new Customer.CustomerBuild()
                .custCode(0L)
                .custName("cj")
                .address(customerAddress)
                .build();
        restTemplate.postForObject(URI,customer, Customer.class );
    }

    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/shop/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(URI,Customer.class, "3");
        Assert.assertNotNull(customer);
        Assert.assertEquals(new Long(3), customer.getCustomerCode());
        Assert.assertEquals("Siraaj", customer.getCustName());
    }

    @Test
    public void testUpdate(){
        String URI =  "http://localhost:8080/shop/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(URI,Customer.class, "3");
        if(customer!=null) {
            String UPDATE_URI = "http://localhost:8080/shop";
            Customer updateCustomer = new Customer.CustomerBuild()
                    .copy(customer)
                    .custName("Siraaj")
                    .build();
            restTemplate.put(UPDATE_URI,updateCustomer);
            Customer updatedCustomer= restTemplate.getForObject(URI, Customer.class, "3");
            Assert.assertEquals(updatedCustomer.getCustName(),"Siraaj");
        }
    }

    @Test
    public void testDelete(){
        String URI =  "http://localhost:8080/shop/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"5");
        Customer customer = restTemplate.getForObject(URI, Customer.class, "5");
        Assert.assertNull(customer);
    }

}
