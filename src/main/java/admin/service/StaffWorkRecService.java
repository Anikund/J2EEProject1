package admin.service;

import admin.dao.domain.Staffworkrec;

import java.sql.Date;
import java.util.List;
public interface StaffWorkRecService
{
    Staffworkrec findByRecordId(Long id);
    List<Staffworkrec> findByEmployeeId(Long employeeid);
    List<Staffworkrec> findByHrId(Long hrid);
    List<Staffworkrec> findByHrName(String name);
    List<Staffworkrec> findByInDate(Date date);
    List<Staffworkrec> findByOutDate(Date date);
    List<Staffworkrec> findByCompany(String company);
    List<Staffworkrec> findAll();
    List<Staffworkrec> addStaffworkrec(Staffworkrec rec);

    Boolean delEmployee(Staffworkrec staffworkrec);


}
