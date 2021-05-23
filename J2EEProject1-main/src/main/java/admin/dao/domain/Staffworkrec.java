package admin.dao.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.validation.constraints.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
public class Staffworkrec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordid;     //记录编号
    @NotBlank(message = "Cannot be blank!")
    private String employeeid; //员工工号
    @NotBlank(message = "Cannot be blank!")
    private String hrid;       //记录人编号

    @NotBlank(message = "Cannot be blank!")
    private String workdate;

    @NotBlank(message = "Cannot be blank!")
    private String recorddate;

    @NotBlank(message = "Cannot be blank!")
    private String worktype;       //工作类型
    @NotBlank(message = "Cannot be blank!")
    private String workconditions;       //工作情况
    @NotBlank(message = "Cannot be blank!")
    private String evaluate;       //评价

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getHrid() {
        return hrid;
    }

    public void setHrid(String hrid) {
        this.hrid = hrid;
    }

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }

    public String getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(String recorddate) {
        this.recorddate = recorddate;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getWorkconditions() {
        return workconditions;
    }

    public void setWorkconditions(String workconditions) {
        this.workconditions = workconditions;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
