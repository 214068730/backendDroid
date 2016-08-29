package droid_backend.services;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.shop.Supplier;
import droid_backend.factory.AddressFactory;
import droid_backend.services.Impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Siraaj on 08/18/2016.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SupplierServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SupplierServiceImpl service;

    @Test
    public void testCreateSupplier() throws Exception {
        AddressVO address = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Supplier supplier = new Supplier.BuilderSupplier()
                .supplierID(0L)
                .supplierName("Conway")
                .supplierAddress(address)
                .build();
        Supplier supplierRecord = service.create(supplier);
        Assert.assertNotNull(supplierRecord);
    }

    @Test(dependsOnMethods = "testCreateSupplier")
    public void testReadAll() throws Exception {
        List<Supplier> suppliers =  service.readAll();
        Assert.assertNotNull(suppliers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdateSupplier() throws Exception {
        Supplier supplier = service.readById(3L);
        if(supplier != null){
            Supplier updateSupplier = new Supplier.BuilderSupplier()
                    .copy(supplier)
                    .supplierName("Neesie")
                    .build();
            Supplier supplierUpdateRecord = service.update(updateSupplier);
            Assert.assertEquals(supplierUpdateRecord.getSupplierName(),"Neesie");
        }
    }

    @Test(dependsOnMethods = "testUpdateSupplier")
    public void testDeleteSupplier() throws Exception {
        Supplier supplier = service.readById(2L);
        if(supplier != null){
            Assert.assertNotNull(supplier);
            service.delete(supplier);
            Supplier deletedSupplier = service.readById(2L);
           Assert.assertNull(deletedSupplier);
        }
    }
}
