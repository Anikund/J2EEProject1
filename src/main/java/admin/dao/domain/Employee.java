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
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;//employee number
    @NotBlank(message = "Cannot be blank!")
    private String name;
    @NotNull
    @Pattern(regexp = "^(Female)|(Male)$", message = "Gender can only be either Female or Male")
    @Size(min=4,max=6,message="Gender can only be either Female or Male")
    private String gender;
    @NotNull
    @Pattern(regexp="^1[1-9]{2}[0-9]{8}$", message="Please input appropriate telephone")

    private String tel;//one tel can only belong to one person
    @NotNull
    @Min(value=18, message="Minimum age: 18")
    @Max(value=65, message="Maximum age: 65")
    private Integer age;
    @NotBlank(message = "Please input the department of this employee!")
    private String department;

    private Boolean isOnTheJob;
    @NotBlank(message = "Please input the company of this guy!")
    private String currentCompany;



}
