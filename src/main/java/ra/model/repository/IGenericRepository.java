package ra.model.repository;

import java.util.List;

public interface IGenericRepository<T, E> {
    List<T> findAll();
    T findById(E id);
    void save(T p);
    void delete(E id);
}
