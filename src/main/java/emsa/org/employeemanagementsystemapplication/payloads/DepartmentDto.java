package emsa.org.employeemanagementsystemapplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto {

    private int departmentId;
    private String jobDepartment;
    private String name;
    private String salary;

}
