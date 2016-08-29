package droid_backend.factory;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class CustomerFactory {
    public static Customer getCustomer(Long custCode, String custName, AddressVO address){
        return new Customer.CustomerBuild()
                .custCode(custCode)
                .custName(custName)
                .address(address)
                .build();
    }
}
