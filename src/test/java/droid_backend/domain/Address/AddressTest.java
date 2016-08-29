package droid_backend.domain.Address;

import droid_backend.domain.address.AddressVO;
import droid_backend.factory.AddressFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class AddressTest extends TestCase {

    @Test
    public void testCreateAddress() throws Exception {
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Assert.assertEquals("15 Sparrow",customerAddress.getStreetName());
        Assert.assertEquals("Rocklands",customerAddress.getSuburb());
        Assert.assertEquals("7798",customerAddress.getPostalCode());
    }

    @Test
    public void testUpdateAddress() throws Exception {
        AddressVO customerAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        AddressVO updateAddress = new AddressVO.AddressBuilder()
                .copy(customerAddress)
                .streetName("57 Spitz Way")
                .suburb("Strandfontien")
                .build();
        Assert.assertEquals("Strandfontien",updateAddress.getSuburb());
        Assert.assertEquals("57 Spitz Way",updateAddress.getStreetName());
    }
}
