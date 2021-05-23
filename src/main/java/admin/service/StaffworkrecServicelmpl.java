package admin.service;

import admin.dao.domain.Staffworkrec;
import admin.dao.repo.StaffworkrecRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Slf4j
@Service
public class StaffworkrecServicelmpl implements StaffworkrecService {

    private StaffworkrecRepository staffworkrecRepo;
    @Autowired
    private void setStaffworkrecRepo(StaffworkrecRepository staffworkrecRepo){
        this.staffworkrecRepo = staffworkrecRepo;
    }

    @Override
    public Staffworkrec findByRecordid(Long id) {
        return staffworkrecRepo.getByRecordid(id);
    }

    @Override
    public List<Staffworkrec> findByEmployeeid(String employeeid) {
        return (List<Staffworkrec>) staffworkrecRepo.findByEmployeeid(employeeid);
    }

    @Override
    public List<Staffworkrec> findByHrid(String hrid) {
        return staffworkrecRepo.findByHrid(hrid);
    }

    @Override
    public List<Staffworkrec> findByWorkdate(String workdate) {
        return staffworkrecRepo.findByWorkdate(workdate);
    }

    @Override
    public List<Staffworkrec> findByRecorddate(String recorddate) {
        return staffworkrecRepo.findByRecorddate(recorddate);
    }

    @Override
    public List<Staffworkrec> findByWorktype(String worktype) {
        return staffworkrecRepo.findByWorktype(worktype);
    }

    @Override
    public List<Staffworkrec> findByWorkconditions(String workconditions) {
        return staffworkrecRepo.findByWorkconditions(workconditions);
    }

    @Override
    public List<Staffworkrec> findByEvaluate(String evaluate) {
        return staffworkrecRepo.findByEvaluate(evaluate);
    }

    @Override
    public List<Staffworkrec> findAll() {
        return staffworkrecRepo.findAll();
    }

    @Override
    public Boolean addStaffworkrec(Staffworkrec staffworkrec) {
        staffworkrecRepo.save(staffworkrec);
        return Boolean.TRUE;
    }

    @Override
    public Boolean delEmployee(Staffworkrec staffworkrec) {
        return null;
    }

    @Override
    public Boolean updateWorkdate(Staffworkrec staffworkrec, String newWorkdate) {
        return null;
    }

    @Override
    public Boolean updateRecorddate(Staffworkrec staffworkrec, String newRecorddate) {
        return null;
    }

    @Override
    public Boolean updateWorktype(Staffworkrec staffworkrec, String newWorktype) {
        return null;
    }

    @Override
    public Boolean updateWorkconditions(Staffworkrec staffworkrec, String newWorkconditions) {
        return null;
    }

    @Override
    public Boolean updateEvaluate(Staffworkrec staffworkrec, String newEvaluate) {
        return null;
    }
}