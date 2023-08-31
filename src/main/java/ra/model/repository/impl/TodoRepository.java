package ra.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class TodoRepository implements ITodoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("SELECT T FROM Todo as T", Todo.class)
                .getResultList();
    }

    @Override
    public Todo findById(Long id) {
        return entityManager.createQuery("SELECT T FROM Todo as T where T.id = :id", Todo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void save(Todo p) {
        if (p.getId() == null) {
            entityManager.persist(p);
        } else {
            entityManager.merge(p);
        }
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
