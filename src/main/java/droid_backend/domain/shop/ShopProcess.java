package droid_backend.domain.shop;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Siraaj on 08/03/2016.
 */

@Entity
public class ShopProcess implements PaymentMethod, ItemCollection,PrintReciepts, Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long orderNo;
    int customerID;
    int employeeID;

    Date datePurchased;
    // ArrayList<Item> list;
    private ShopProcess(){}

    public Long getOrderNo() {
        return orderNo;
    }



    public ShopProcess(BuildProcess purchaseBuilder){

        this.orderNo = purchaseBuilder.orderNo;
        this.customerID = purchaseBuilder.customerID;
        this.employeeID = purchaseBuilder.employeeID;
        this.datePurchased = purchaseBuilder.datePurchased;
       // list = new ArrayList<Item>();
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public int getEmployeeID(){return this.employeeID;}

    public Date getDate() {
        return this.datePurchased;
    }
    public void add(Item item){
        //list.add(item);
    }


    public void printReciept(){
        /*System.out.println("Receipt\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("OrderNo. "+ orderNo);
        System.out.println("Employee name: "+employee.getName());
        System.out.println(customer.toString());
        System.out.println(list.toString());*/
    }

    @Override
    public void printRefund() {
 /*       System.out.println("Refund\n\t\t\t\t"+dateFormat.format(date));
        System.out.println("Employee name: "+employee.getName());
        System.out.println(customer.getCustName() +" has been awarded a refund");*/
    }

    public void payMethod(String paymentMethod){
        System.out.println("Payment method: "+paymentMethod);
    }

    @Override
    public void collectionType(String collectionType) {
       /* System.out.println(customer.getCustName());
        System.out.println("Has requested requested:"+collectionType);*/
    }


    public static class BuildProcess{
        Long orderNo;
        Item item;
        int customerID;
        int employeeID;
        Date datePurchased;


        public BuildProcess orderNo(Long orderNo){
            this.orderNo = orderNo;
            return this;
        }

        public BuildProcess customer(int customerID){
            this.customerID = customerID;
            return this;
        }

        public BuildProcess item(Item item){
            this.item = item;
            return this;
        }

        public BuildProcess employee(int employeeID){
            this.employeeID = employeeID;
            return this;
        }

        public BuildProcess date(){
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            datePurchased = new Date();
            return this;
        }

        public BuildProcess copy(ShopProcess order){
            this.orderNo = order.orderNo;
            this.customerID = order.customerID;
            this.employeeID = order.employeeID;
            return this;
        }

        public ShopProcess build()
        {

            return new ShopProcess(this);
        }
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProcess order = (ShopProcess) o;

        return orderNo == order.orderNo;

    }

    @Override
    public int hashCode() {
        return (int) (orderNo ^ (orderNo >>> 32));
    }
}
