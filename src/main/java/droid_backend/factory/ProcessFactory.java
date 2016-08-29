package droid_backend.factory;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.Item;
import droid_backend.domain.shop.ShopProcess;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class ProcessFactory {
    public static ShopProcess startProcess(Long orderNo, int customerID, int employee,Item item){
        return new ShopProcess.BuildProcess().orderNo(orderNo).customer(customerID).employee(employee).build();
    }
}
