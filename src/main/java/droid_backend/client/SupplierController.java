package droid_backend.client;

import droid_backend.domain.shop.Supplier;
import droid_backend.services.Impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RestController
@RequestMapping(value="/shop")
public class SupplierController {

    @Autowired
    SupplierServiceImpl service;

    @RequestMapping(value = "/supplier/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Supplier findById(@PathVariable Long id){
        return service.readById(id);
    }


    @RequestMapping(value = "/supplier/create",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Supplier create(@RequestBody Supplier supplier){
        return  service.create(supplier);
    }

    @RequestMapping(value = "/supplier/update",method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Supplier supplier){
        service.update(supplier);
    }

    @RequestMapping(value = "/supplier/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Supplier> findAll(){
        return service.readAll();
    }


    @RequestMapping(value="supplier/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        Supplier deleteSupplier= service.readById(id);
        if(deleteSupplier!=null) {
            service.delete(deleteSupplier);
        }
    }
}
