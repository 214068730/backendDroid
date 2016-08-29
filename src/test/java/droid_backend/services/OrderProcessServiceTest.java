package droid_backend.services;

import droid_backend.App;
import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.Item;
import droid_backend.domain.shop.ShopProcess;
import droid_backend.services.Impl.CustomerServceImpl;
import droid_backend.services.Impl.EmployeeServiceImpl;
import droid_backend.services.Impl.ItemServiceImpl;
import droid_backend.services.Impl.SalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/18/2016.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrderProcessServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SalesServiceImpl service;
    @Autowired
    CustomerServceImpl customerService;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ItemServiceImpl itemService;

    @Test
    public void testCreateOrder() throws Exception {

        Customer customerRecord =customerService.readById(1L);
        Employee employeeRecord = employeeService.readById(1L);
        Item itemRecord = itemService.readById(4L);


        ShopProcess process = new  ShopProcess.BuildProcess()
                .orderNo(0L)
                .customer(Integer.parseInt(customerRecord.getCustomerCode()+""))
                .employee(Integer.parseInt(employeeRecord.getEmpCode()+""))
                .date()
                .item(itemRecord)
                .build();
        ShopProcess orderRecord = service.create(process);

    }

    @Test(dependsOnMethods = "testCreateOrder")
    public void testReadAll() throws Exception {
        Iterable<ShopProcess> sales =  service.readAll();
        Assert.assertNotNull(sales);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdateOrder() throws Exception {
        ShopProcess order = service.readById(3L);
        Customer customer  = customerService.readById(3L);
        if(order != null){
            ShopProcess updateOrder = new ShopProcess.BuildProcess()
                    .copy(order)
                    .customer(Integer.parseInt(customer.getCustomerCode()+""))
                    .build();
            ShopProcess updatedOrder = service.update(updateOrder);
            Assert.assertNotNull(updatedOrder);
        }
    }

   /* @Test(dependsOnMethods = "testUpdateOrder")
    public void testDeleteOrder() throws Exception {
        ShopProcess order = service.readById(4L);
        if(order != null){
            Assert.assertNotNull(order);
            service.delete(order);
            ShopProcess deleteOrder = service.readById(4L);
            Assert.assertNull(deleteOrder);
        }
    }*/
}
