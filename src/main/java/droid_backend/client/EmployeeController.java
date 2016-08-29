package droid_backend.client;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.services.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Siraaj on 08/21/2016.
 */

@RestController
@RequestMapping(value="/shop")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl service;

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Employee findById(@PathVariable Long id){
        return   service.readById(id);
    }


    @RequestMapping(value = "/employee/create",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Employee create(@RequestBody Employee employee){
        return  service.create(employee);
    }

    @RequestMapping(value = "/employee/update",method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Employee employee){
        service.update(employee);
    }

    @RequestMapping(value = "/employee/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> findAll(){
        return service.readAll();
    }


    @RequestMapping(value="employee/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        Employee deleteEmployee= service.readById(id);
        if(deleteEmployee!=null) {
            service.delete(deleteEmployee);
        }
    }

}
