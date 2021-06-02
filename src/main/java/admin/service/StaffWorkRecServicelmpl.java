package admin.service;

import admin.dao.domain.StaffWorkRec;
import admin.dao.repo.StaffWorkRecRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Arrays;
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
    public StaffWorkRec findByRecordId(Long id) {
        return staffworkrecRepo.getByRecordId(id);
    }

    @Override
    public List<StaffWorkRec> findByEmployeeId(Long employeeid) {
        return  staffworkrecRepo.findByEmployeeId(employeeid);
    }

    @Override
    public List<StaffWorkRec> findByHrId(Long hrid) {
        return staffworkrecRepo.findByHrId(hrid);
    }

    @Override
    public List<StaffWorkRec> findByHrName(String name) {
        return staffworkrecRepo.findByHrName(name);
    }

    @Override
    public List<StaffWorkRec> findByInDate(Date date) {
        return staffworkrecRepo.findByInDate(date);
    }

    @Override
    public List<StaffWorkRec> findByOutDate(Date date) {
        return staffworkrecRepo.findByOutDate(date);
    }

    @Override
    public List<StaffWorkRec> findByCompany(String company) {
        return staffworkrecRepo.findByCompany(company);
    }


    @Override
    public List<StaffWorkRec> findAll() {
        return staffworkrecRepo.findAll();
    }



    @Override
    public Boolean delEmployee(StaffWorkRec staffworkrec) {
        return null;
    }

}