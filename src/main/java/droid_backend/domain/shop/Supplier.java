package droid_backend.domain.shop;

import droid_backend.domain.address.AddressVO;

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
public class Supplier implements Serializable,ISupplierEvents {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    Long supplierID;
    String supplierName;
    @Embedded
    AddressVO supplierAddress;
    Date dateArrived;
    //Map<Long,Date> supplierEventHistory = new HashMap();

    private Supplier(){
    }

    public Supplier(BuilderSupplier builderSupplier){
        DateFormat dateFormat;
        supplierID = builderSupplier.supplierID;
        supplierName = builderSupplier.supplierName;
        supplierAddress = builderSupplier.supplierAddress;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateArrived = new Date();
      //  SupplierAdded();
    }


    public Long getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public AddressVO getSupplierAddress() {
        return supplierAddress;
    }

    public String getPostalCode(){
        return supplierAddress.getPostalCode();
    }

    public String getStreetName(){
        return supplierAddress.getStreetName();
    }

    public String getSuburb(){
        return supplierAddress.getSuburb();
    }

    public void viewSupplier(){
        System.out.println("Supplier ID: "+supplierID);
        System.out.println("Supplier Name: "+supplierName);
        System.out.println("Supplier Address");
        supplierAddress.viewAddress();
    }

    @Override
    public void SupplierAdded() {
        /*supplierEventHistory.put(supplierID,date);*/
    }

    @Override
    public void viewSupplierHistory(Long supplierID) {
        /*if(!supplierEventHistory.get(supplierID).equals(null)) {
            System.out.println("Partners since");
            System.out.println(supplierEventHistory.get(supplierID));
            System.out.println("With: "+supplierName);
        }*/
    }

    //builder
    public static class BuilderSupplier{
        Long supplierID;
        String supplierName;
        AddressVO supplierAddress;

        public BuilderSupplier supplierID(Long supplierID){
            this.supplierID = supplierID;
            return this;
        }

        public BuilderSupplier supplierName(String supplierName){
            this.supplierName = supplierName;
            return this;
        }

        public BuilderSupplier supplierAddress(AddressVO supplierAddress){
            this.supplierAddress = supplierAddress;
            return this;
        }

        public BuilderSupplier copy(Supplier supplier){
            this.supplierID = supplier.supplierID;
            this.supplierName = supplier.supplierName;
            this.supplierAddress = supplier.supplierAddress;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return supplierID == supplier.supplierID;

    }

    @Override
    public int hashCode() {
        return (int) (supplierID ^ (supplierID >>> 32));
    }
}
