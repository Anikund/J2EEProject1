package admin.dao.repo;

import admin.dao.domain.Admin;
import admin.dao.domain.HR;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    Admin findByUsername(String username);
}
