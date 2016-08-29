package droid_backend.services;

import java.util.List;
import java.util.Set;
/**
 * Created by Siraaj on 08/01/2016.
 */


public interface Service<E,ID> {
    E create(E entity);

    E readById(ID id);

    List<E> readAll();

    E update(E entity);

    void delete(E entity);

}
