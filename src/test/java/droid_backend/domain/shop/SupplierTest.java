package droid_backend.domain.shop;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.shop.Supplier;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.SupplierFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Siraaj on 08/03/2016.
 */
public class SupplierTest extends TestCase {

    @Test
    public void testCreateSupplier() throws Exception {
        AddressVO supplierAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Supplier supplier = SupplierFactory.getSupplier(01L,"Camen",supplierAddress);

        Assert.assertEquals("Camen",supplier.getSupplierName());
        Assert.assertEquals("Rocklands",supplier.getSuburb());
    }

    @Test
    public void tesUpdateSupplier() throws Exception {
        AddressVO supplierAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Supplier supplier = SupplierFactory.getSupplier(01L,"Camen",supplierAddress);

        Supplier updateSupplier = new Supplier.BuilderSupplier()
                .copy(supplier)
                .supplierName("Shireen")
                .build();

        Assert.assertEquals("Shireen",updateSupplier.getSupplierName());
    }
}
