package droid_backend.client;

import droid_backend.domain.shop.Orderline;
import droid_backend.services.Impl.OrderLineServiceImpl;
import droid_backend.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RestController
@RequestMapping(value="/shop")
public class OrderLineController {
    @Autowired
    OrderLineServiceImpl service;

    @RequestMapping(value = "/orderline/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Orderline findById(@PathVariable Long id){
        return service.readById(id);
    }


    @RequestMapping(value = "/orderline/create",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Orderline create(@RequestBody Orderline orderline){
        return  service.create(orderline);
    }

    @RequestMapping(value = "/orderline/update",method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Orderline orderline){
        service.update(orderline);
    }

    @RequestMapping(value = "/orderline/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Orderline> findAll(){
        return service.readAll();
    }


    @RequestMapping(value="orderline/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        Orderline deleteOrderLine= service.readById(id);
        if(deleteOrderLine!=null) {
            service.delete(deleteOrderLine);
        }
    }
}
