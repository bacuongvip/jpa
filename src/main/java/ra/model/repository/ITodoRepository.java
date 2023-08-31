package ra.model.repository;

import org.springframework.stereotype.Repository;
import ra.model.entity.Todo;

import java.util.List;
@Repository
public interface ITodoRepository extends IGenericRepository<Todo, Long>{
}
