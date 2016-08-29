package droid_backend.client;

import droid_backend.domain.shop.Item;
import droid_backend.services.Impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Siraaj on 08/21/2016.
 */
@RestController
@RequestMapping(value="/shop")
public class ItemController {
    @Autowired
    ItemServiceImpl service;

    @RequestMapping(value = "/item/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Item findById(@PathVariable Long id){
        return   service.readById(id);
    }


    @RequestMapping(value = "/item/create",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Item create(@RequestBody Item item){
        return  service.create(item);
    }

    @RequestMapping(value = "/item/update",method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Item item){
        service.update(item);
    }

    @RequestMapping(value = "/item/findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Item> findAll(){
        return service.readAll();
    }


    @RequestMapping(value="item/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        Item deleteItem= service.readById(id);
        if(deleteItem!=null) {
            service.delete(deleteItem);
        }
    }

}
