package admin.service;

import admin.dao.domain.Staffworkrec;
import admin.dao.repo.StaffWorkRecRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Slf4j
@Service
public class StaffWorkRecServicelmpl implements StaffWorkRecService {

    private StaffWorkRecRepository staffworkrecRepo;
    @Autowired
    private void setStaffWorkRecRepo(StaffWorkRecRepository staffworkrecRepo){
        this.staffworkrecRepo = staffworkrecRepo;
    }

    @Override
    public Staffworkrec findByRecordId(Long id) {
        return staffworkrecRepo.getByRecordId(id);
    }

    @Override
    public List<Staffworkrec> findByEmployeeId(Long employeeid) {
        return  staffworkrecRepo.findByEmployeeId(employeeid);
    }

    @Override
    public List<Staffworkrec> findByHrId(Long hrid) {
        return staffworkrecRepo.findByHrId(hrid);
    }

    @Override
    public List<Staffworkrec> findByHrName(String name) {
        return staffworkrecRepo.findByHrName(name);
    }

    @Override
    public List<Staffworkrec> findByInDate(Date date) {
        return staffworkrecRepo.findByInDate(date);
    }

    @Override
    public List<Staffworkrec> findByOutDate(Date date) {
        return staffworkrecRepo.findByOutDate(date);
    }

    @Override
    public List<Staffworkrec> findByCompany(String company) {
        return staffworkrecRepo.findByCompany(company);
    }


    @Override
    public List<Staffworkrec> findAll() {
        return staffworkrecRepo.findAll();
    }

    @Override
    public List<Staffworkrec> addStaffworkrec(Staffworkrec rec) {
        return null;
    }


    @Override
    public Boolean delEmployee(Staffworkrec staffworkrec) {
        return null;
    }

}