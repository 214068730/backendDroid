package droid_backend.client;

import droid_backend.domain.customer.Customer;
import droid_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Siraaj on 08/20/2016.
 */


@RestController
@RequestMapping(value="/shop")
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Customer findById(@PathVariable Long id){
        return   service.readById(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Customer create(@RequestBody Customer customer){
        return  service.create(customer);
    }

    @RequestMapping(method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Customer customer){
        service.update(customer);
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findAll(){
        return service.readAll();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        Customer customerDeleted= service.readById(id);
        if(customerDeleted!=null) {
            service.delete(customerDeleted);
        }
    }
}
