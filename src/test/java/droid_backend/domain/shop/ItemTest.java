package droid_backend.domain.shop;

import droid_backend.domain.shop.Item;
import droid_backend.factory.ItemFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class ItemTest extends TestCase {

    @Test
    public void testCreateItem() throws Exception {
        Item item1 = ItemFactory.getItem(100L,"Chocolate",4.00);
        Assert.assertEquals(item1.getItemName(),"Chocolate");
    }

    @Test
    public void testItemUpdate() throws Exception {
        Item item = ItemFactory.getItem(100L,"Chocolate",4.00);
        Item itemUpdate = new Item.ItemBuilder()
                .copy(item)
                .itemName("Becon Chocolate")
                .build();
        Assert.assertEquals(itemUpdate.getItemName(), "Becon Chocolate");

    }
}
