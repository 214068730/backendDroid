package droid_backend.repository;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.shop.Supplier;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.SupplierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/14/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudSupplierTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SupplierRepository repo;


    @Test
    public void testCreate() throws Exception {

        AddressVO supplierAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Supplier supplier = SupplierFactory.getSupplier(01L,"Camen",supplierAddress);

        Supplier record = repo.save(supplier);
        Assert.assertNotNull(record);
    }
}
