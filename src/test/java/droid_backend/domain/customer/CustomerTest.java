package droid_backend.domain.customer;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.CustomerFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Siraaj on 08/03/2016.
 */
public class CustomerTest extends TestCase {

    @Test
    public void testCreateCustomer() throws Exception {
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        Assert.assertEquals("Rocklands",customer.getSuburb());
        Assert.assertEquals("Shireen",customer.getCustName());
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);

        AddressVO updateAddress = AddressFactory.getAddress("7798","57 Spitz Way","Strandfontien");
        Customer updateCustomer = new Customer.CustomerBuild()
                .copy(customer)
                .address(updateAddress)
                .build();

        Assert.assertEquals("57 Spitz Way",updateCustomer.getStreetName());
        Assert.assertEquals("Shireen",updateCustomer.getCustName());

    }
}
