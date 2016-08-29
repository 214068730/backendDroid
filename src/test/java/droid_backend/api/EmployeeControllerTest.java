package droid_backend.api;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.employee.Employee;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.EmployeeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeControllerTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testCreate(){
         String URI =  "http://localhost:8080/shop/item/create";
        RestTemplate restTemplate = new RestTemplate();
        AddressVO employeeAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Employee employee = EmployeeFactory.getEmployee(0L, "Kashiefa", "Cottle", employeeAddress);
        restTemplate.postForObject(URI,employee, Employee.class );
    }

    @Test
    public void testFindById() {
        String URI =  "http://localhost:8080/shop/employee/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(URI,Employee.class, "1");
        Assert.assertNotNull(employee);
        Assert.assertEquals(new Long(1), employee.getEmpCode());
        Assert.assertEquals("Kashiefa", employee.getName());
    }

    @Test
    public void testUpdate() {
        String URI = "http://localhost:8080/shop/{id}";
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(URI, Employee.class, "2");
        if (employee != null) {
            String UPDATE_URI = "http://localhost:8080/shop/employee/update";
            Employee updateCustomer = new Employee.EmployeeBuilder()
                    .copy(employee)
                    .name("Siraaj")
                    .build();
            restTemplate.put(UPDATE_URI, updateCustomer);
            Employee updatedEmployee = restTemplate.getForObject(URI, Employee.class, "3");
            Assert.assertEquals(updatedEmployee.getName(), "Siraaj");
        }
    }

    @Test
    public void testDelete(){
        String URI =  "http://localhost:8080/shop/employee/{id}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(URI,"2");
        Employee employee= restTemplate.getForObject(URI, Employee.class, "2");

        Assert.assertNull(employee);


    }
}
