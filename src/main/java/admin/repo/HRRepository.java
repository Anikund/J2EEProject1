package admin.repo;

import admin.domain.HR;
import org.springframework.data.repository.CrudRepository;

public interface HRRepository extends CrudRepository<HR, Long> {
    HR findByUsername(String username);
}
