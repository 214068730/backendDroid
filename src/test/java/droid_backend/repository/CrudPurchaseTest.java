package droid_backend.repository;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.Item;
import droid_backend.domain.shop.Orderline;
import droid_backend.domain.shop.ShopProcess;
import droid_backend.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/14/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudPurchaseTest extends AbstractTestNGSpringContextTests{

    private Long id;
    @Autowired
    SalesRepository repo;
    @Autowired
    OrderlineRepository repository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ItemRepository itemRepository;


    @Test
    public void testCreateSales() throws Exception {
        //Customer
        /*AddressVO customerAddress = AddressFactory.getAddress("7798", "15 Sparrow", "Rocklands");
        Customer customer = CustomerFactory.getCustomer(1000L, "Shireen", customerAddress);*/
        Customer customerRecord = customerRepository.findOne(1L);
        //Assert.assertNotNull(customerRecord);

        //Employee
        /*AddressVO employeeAddress = AddressFactory.getAddress("1785", "57 Spitz Way", "Strandfontien");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);*/
        Employee employeeRecord = employeeRepository.findOne(1L);
        Assert.assertNotNull(employeeRecord);

        //Item
        //Item item1 = ItemFactory.getItem(100L, "Chocolate");
        Item itemRecord = itemRepository.findOne(1L);
        Assert.assertNotNull(itemRecord);

        //generate order
        ShopProcess process = new  ShopProcess.BuildProcess()
                .orderNo(0L)
                .customer(Integer.parseInt(customerRecord.getCustomerCode()+""))
                .employee(Integer.parseInt(employeeRecord.getEmpCode()+""))
                .item(itemRecord)
                .build();
        ShopProcess order = repo.save(process);
        Assert.assertNotNull(order);
        Orderline orderline = new Orderline.OrderLineBuilder()
                .orderID(order.getOrderNo())
                .productID(itemRecord.getItemCode())
                .build();
        Orderline orders = repository.save(orderline);
        Assert.assertNotNull(orders);

    }
}
