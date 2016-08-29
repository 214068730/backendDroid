package droid_backend.repository;

import droid_backend.App;
import droid_backend.domain.shop.Item;
import droid_backend.factory.ItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/13/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudItemTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ItemRepository repo;


    @Test
    public void testCreate() throws Exception {
        Item item1 = ItemFactory.getItem(100L,"Chocolate",4.00);
        Item item = repo.save(item1);
        Assert.assertNotNull(item);
    }
}
