package admin.service;

import admin.dao.domain.StaffWorkRec;

import java.sql.Date;
import java.util.List;
public interface StaffWorkRecService
{
    StaffWorkRec findByRecordId(Long id);
    List<StaffWorkRec> findByEmployeeId(Long employeeid);
    List<StaffWorkRec> findByHrId(Long hrid);
    List<StaffWorkRec> findByHrName(String name);
    List<StaffWorkRec> findByInDate(Date date);
    List<StaffWorkRec> findByOutDate(Date date);
    List<StaffWorkRec> findByCompany(String company);
    List<StaffWorkRec> findAll();


    Boolean delEmployee(StaffWorkRec staffworkrec);


}
