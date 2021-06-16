package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T getID (Integer id);

    List<T> getAll ();

    T create (T object);

    T update(Integer id, T object);

    T delete(Integer id);
}
