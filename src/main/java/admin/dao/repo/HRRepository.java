package admin.dao.repo;

import admin.dao.domain.HR;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HRRepository extends CrudRepository<HR, Long> {
    HR findByUsername(String username);

    List<HR> findAll();
}
