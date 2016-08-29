package droid_backend.factory;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.shop.Supplier;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class SupplierFactory {
    public static Supplier getSupplier(Long supplierID, String supplierName, AddressVO address){
        return new Supplier.BuilderSupplier()
                .supplierID(supplierID)
                .supplierName(supplierName)
                .supplierAddress(address)
                .build();
    }
}
