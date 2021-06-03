package admin.dao.repo;


import admin.dao.domain.Staffworkrec;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface StaffWorkRecRepository extends CrudRepository<Staffworkrec, Long> {

    Staffworkrec getByRecordId(Long id);
    List<Staffworkrec> findByEmployeeId(Long employeeId);
    List<Staffworkrec> findByHrId(Long hrId);
    List<Staffworkrec> findByHrName(String name);
    List<Staffworkrec> findByInDate(Date date);
    List<Staffworkrec> findByOutDate(Date date);
    List<Staffworkrec> findByCompany(String company);
    List<Staffworkrec> findAll();


}
