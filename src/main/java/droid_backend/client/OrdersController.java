package droid_backend.client;

import droid_backend.domain.customer.Customer;
import droid_backend.domain.employee.Employee;
import droid_backend.domain.shop.ShopProcess;
import droid_backend.services.Impl.SalesServiceImpl;
import javafx.scene.SnapshotParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Siraaj on 08/21/2016.
 */

@RestController
@RequestMapping(value="/shop")
public class OrdersController {

    @Autowired
    SalesServiceImpl service;

    @RequestMapping(value = "/sales/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ShopProcess findById(@PathVariable Long id){
        return service.readById(id);
    }


    @RequestMapping(value = "/sales/create",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ShopProcess create(@RequestBody ShopProcess sales){
             return  service.create(sales);
    }

    @RequestMapping(value = "/sales/update",method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ShopProcess sale){
        service.update(sale);
    }

    @RequestMapping(value = "/sales/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<ShopProcess> findAll(){
        return service.readAll();
    }


    @RequestMapping(value="sales/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        ShopProcess deleteSale= service.readById(id);
        if(deleteSale!=null) {
            service.delete(deleteSale);
        }
    }
}
