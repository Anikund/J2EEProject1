package admin.dao.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
public class Staffworkrec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;     //记录编号


    private Long employeeId; //员工工号

    private Long hrId;       //记录人编号
    private String hrName;

    private Date inDate;


    private Date outDate;

    private String company;




}
