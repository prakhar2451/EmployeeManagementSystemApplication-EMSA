package emsa.org.employeemanagementsystemapplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    @Column(name = "job_dept", length = 100, nullable = false)
    private String jobDepartment;

    @Column(name = "job_name", length = 100, nullable = false)
    private String name;

    @Column(name = "job_description", length = 100, nullable = false)
    private String description;

    @Column(name = "salary", length = 100, nullable = false)
    private String salary;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employee;



}
