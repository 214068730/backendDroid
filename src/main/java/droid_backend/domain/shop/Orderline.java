package droid_backend.domain.shop;

import org.aspectj.weaver.ast.Or;
import sun.util.calendar.BaseCalendar;
import sun.util.resources.cldr.gv.LocaleNames_gv;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Siraaj on 08/14/2016.
 */
@Entity
public class Orderline implements Serializable {

    @Id
    Long orderID;
    Long productID;
    int quantity;
    public Orderline(){}

    public Orderline(OrderLineBuilder orderLineBuilder) {
        this.orderID = orderLineBuilder.orderID;
        this.productID = orderLineBuilder.productID;
    }

    public Long getOrderID(){return this.orderID;}

    public Long getProductID(){return this.productID;}
    public int getQuantity(){return this.quantity;}

    public static class OrderLineBuilder{
        Long orderID;
        Long productID;

        public OrderLineBuilder orderID(Long orderID){
            this.orderID = orderID;
            return this;
        }

        public OrderLineBuilder productID(Long productID){
            this.productID = productID;
            return this;
        }


        public OrderLineBuilder copy(Orderline orderline){
            this.orderID = orderline.productID;
            return this;
        }

        public Orderline build(){
            return new Orderline(this);
        }
    }
}
