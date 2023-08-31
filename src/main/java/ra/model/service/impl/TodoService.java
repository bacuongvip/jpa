package ra.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.Todo;
import ra.model.repository.ITodoRepository;
import ra.model.service.ITodoService;

import java.util.List;
@Service
public class TodoService implements ITodoService {
    @Autowired
    private ITodoRepository todoRepository;
    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void save(Todo p) {
        todoRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        todoRepository.delete(id);
    }
}
