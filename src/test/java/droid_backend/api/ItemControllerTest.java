package droid_backend.api;

import droid_backend.App;
import droid_backend.domain.shop.Item;
import droid_backend.factory.ItemFactory;
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
public class ItemControllerTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testCreate(){
        String URI =  "http://localhost:8080/shop/item/create";
        RestTemplate restTemplate = new RestTemplate();
        Item item = ItemFactory.getItem(0L,"Apple Strike",4.00);
        restTemplate.postForObject(URI,item, Item.class );
    }

    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/shop/item/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Item item = restTemplate.getForObject(URI,Item.class, "1");
        Assert.assertNotNull(item);
        Assert.assertEquals(new Long(1), item.getItemCode());
        Assert.assertEquals("future life", item.getItemName());
    }

    @Test
    public void testUpdate() {
        String URI = "http://localhost:8080/shop/item/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Item item = restTemplate.getForObject(URI, Item.class, "1");
        if (item != null) {
            String UPDATE_URI = "http://localhost:8080/shop/item/update";
            Item updateItem = new Item.ItemBuilder()
                    .copy(item)
                    .itemName("future life")
                    .build();
            restTemplate.put(UPDATE_URI, updateItem);
            Item updatedItem = restTemplate.getForObject(URI, Item.class, "1");
            Assert.assertEquals(updatedItem.getItemName(), "future life");
        }
    }

    @Test
    public void testDelete(){
        String GET_URI =  "http://localhost:8080/shop/item/{id}";
        String URI =  "http://localhost:8080/shop/item/delete/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"6");
        Item item = restTemplate.getForObject(GET_URI,Item.class, "6");
        Assert.assertNull(item);


    }

}
