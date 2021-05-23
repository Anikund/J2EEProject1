package admin.dao.repo;


import admin.dao.domain.Staffworkrec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StaffworkrecRepository extends CrudRepository<Staffworkrec, Long> {

    Staffworkrec getByRecordid(Long id);
    Staffworkrec findByEmployeeid(String employeeId);
    List<Staffworkrec> findByHrid(String hrId);
    List<Staffworkrec> findByWorkdate(String workdate);
    List<Staffworkrec> findByRecorddate(String recorddate);
    List<Staffworkrec> findByWorktype(String worktype);
    List<Staffworkrec> findByWorkconditions(String workconditions);
    List<Staffworkrec> findByEvaluate(String evaluate);

    List<Staffworkrec> findAll();


}
