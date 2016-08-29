package droid_backend.api;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.shop.Supplier;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.SupplierFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SupplierControllerTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testCreate(){
        String URI =  "http://localhost:8080/shop/supplier/create";
        RestTemplate restTemplate = new RestTemplate();
        AddressVO supplierAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Supplier supplier = SupplierFactory.getSupplier(0L,"Camen",supplierAddress);
        restTemplate.postForObject(URI,supplier, Supplier.class );
    }

    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/shop/supplier/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Supplier supplier = restTemplate.getForObject(URI,Supplier.class, "1");
        Assert.assertNotNull(supplier);
        Assert.assertEquals(new Long(1), supplier.getSupplierID());
        Assert.assertEquals("Bevy", supplier.getSupplierName());
    }

    @Test
    public void testUpdate() {
        String URI = "http://localhost:8080/shop/supplier/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Supplier supplier = restTemplate.getForObject(URI, Supplier.class, "1");
        if (supplier != null) {
            String UPDATE_URI = "http://localhost:8080/shop/supplier/update";
            Supplier updateSupplier = new Supplier.BuilderSupplier()
                    .copy(supplier)
                    .supplierName("Bevy")
                    .build();
            restTemplate.put(UPDATE_URI, updateSupplier);
            Supplier updatedSupplier = restTemplate.getForObject(URI, Supplier.class, "1");
            Assert.assertEquals(updatedSupplier.getSupplierName(), "Bevy");
        }
    }

    @Test
    public void testDelete(){
        String GET_URI =  "http://localhost:8080/shop/supplier/{id}";
        String URI =  "http://localhost:8080/shop/supplier/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"4");
        Supplier supplier = restTemplate.getForObject(GET_URI,Supplier.class, "4");
        Assert.assertNull(supplier);


    }

}
