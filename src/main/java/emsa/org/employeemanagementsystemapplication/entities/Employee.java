package emsa.org.employeemanagementsystemapplication.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String name;
    private String gender;
    private int age;
    private String jobRole;
    private long contact;
    private String empEmail;
    private  String empPassword;

    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Qualification> qualification;
}
