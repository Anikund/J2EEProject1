package admin.dao.repo;


import admin.dao.domain.StaffWorkRec;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface StaffWorkRecRepository extends CrudRepository<StaffWorkRec, Long> {

    StaffWorkRec getByRecordId(Long id);
    List<StaffWorkRec> findByEmployeeId(Long employeeId);
    List<StaffWorkRec> findByHrId(Long hrId);
    List<StaffWorkRec> findByHrName(String name);
    List<StaffWorkRec> findByInDate(Date date);
    List<StaffWorkRec> findByOutDate(Date date);
    List<StaffWorkRec> findByCompany(String company);
    List<StaffWorkRec> findAll();


}
