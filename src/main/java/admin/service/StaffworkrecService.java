package admin.service;

import admin.dao.domain.Staffworkrec;
import admin.dao.repo.StaffworkrecRepository;
import lombok.Data;

import java.util.List;
public interface StaffworkrecService
{
    Staffworkrec findByRecordid(Long id);
    List<Staffworkrec> findByEmployeeid(String employeeid);
    List<Staffworkrec> findByHrid(String hrid);
    List<Staffworkrec> findByWorkdate(String workdate);
    List<Staffworkrec> findByRecorddate(String recorddate);
    List<Staffworkrec> findByWorktype(String worktype);
    List<Staffworkrec> findByWorkconditions(String workconditions);
    List<Staffworkrec> findByEvaluate(String evaluate);

    List<Staffworkrec> findAll();
    Boolean addStaffworkrec(Staffworkrec staffworkrec);

    Boolean delEmployee(Staffworkrec staffworkrec);
    Boolean updateWorkdate(Staffworkrec staffworkrec, String newWorkdate);
    Boolean updateRecorddate(Staffworkrec staffworkrec,String newRecorddate);
    Boolean updateWorktype(Staffworkrec staffworkrec, String newWorktype);
    Boolean updateWorkconditions(Staffworkrec staffworkrec, String newWorkconditions);
    Boolean updateEvaluate(Staffworkrec staffworkrec, String newEvaluate);

}
