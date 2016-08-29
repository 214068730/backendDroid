package droid_backend.services;

import droid_backend.App;
import droid_backend.domain.shop.Item;
import droid_backend.services.Impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/17/2016.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ItemServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ItemServiceImpl service;

    @Test
    public void testCreateItem() throws Exception {
        Item item = new Item.ItemBuilder()
                .itemCode(0L)
                .itemName("Milk")
                .itemPrice(10.00)
                .build();
        Item itemRecord = service.create(item);
        Assert.assertNotNull(itemRecord);
    }

    @Test(dependsOnMethods = "testCreateItem")
    public void testReadAll() throws Exception {
        Iterable<Item> items =  service.readAll();
        Assert.assertNotNull(items);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testItemUpdate() throws Exception {
        Item item = service.readById(4L);
        if(item != null){
            Item updateItem = new Item.ItemBuilder()
                    .copy(item)
                    .itemName("Condoms")
                    .build();
            Item updatedItemRecord = service.update(updateItem);
            Assert.assertEquals(updatedItemRecord.getItemName(),"Condoms");
        }
    }

    @Test(dependsOnMethods = "testItemUpdate")
    public void testDeleteItem() throws Exception {
        Item item = service.readById(2L);
        if(item != null){
            Assert.assertNotNull(item);
            service.delete(item);
            Item deletedItem = service.readById(2L);
            Assert.assertNull(deletedItem);
        }
    }
}
