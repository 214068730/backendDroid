package droid_backend.domain.shop;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siraaj on 08/03/2016.
 */

@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long itemCode;
    String itemName;
    double price;
    Date dateCreated;
    //Map<Long,Date> itemEventHistory = new HashMap();

    private Item() {
    }

    public Item(ItemBuilder itemBuilder) {
        this.itemCode = itemBuilder.itemCode;
        this.itemName = itemBuilder.itemName;
        this.price = itemBuilder.price;
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateCreated = new Date();
        //ItemAriived();
    }

    public Long getItemCode() {
        return itemCode;
    }
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "itemCode='" + itemCode + '\'' +", itemName='" + itemName;
    }

   // @Override
    /*
    public void ItemAriived() {
        itemEventHistory.put(itemCode,date);
    }

    public void viewItemHistory(Long itemCode) {
        if (!itemEventHistory.get(itemCode).equals(null)) {
            System.out.println("Item arrived on");
            System.out.println(itemEventHistory.get(itemCode));
            System.out.println("By: " + itemName);

        }
    }*/

    public static class ItemBuilder{
        Long itemCode;
        String itemName;
        double price;

        public ItemBuilder itemCode(Long itemCode){
            this.itemCode = itemCode;
            return this;
        }

        public ItemBuilder itemPrice(double price){
            this.price = price;
            return this;
        }

        public ItemBuilder itemName(String itemName){
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder copy(Item item){
            this.itemCode = item.itemCode;
            this.itemName = item.itemName;
            this.price = item.price;
            return this;
        }

        public Item build(){
            return new Item(this);
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return itemCode == item.itemCode;

    }

    @Override
    public int hashCode() {
        return (int) (itemCode ^ (itemCode >>> 32));
    }
}
