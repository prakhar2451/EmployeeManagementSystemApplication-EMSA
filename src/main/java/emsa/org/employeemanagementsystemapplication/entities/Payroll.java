package emsa.org.employeemanagementsystemapplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "payroll")
@NoArgsConstructor
@Getter
@Setter
public class Payroll {

    int employeeId;
    int jobId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int salaryId;
    int leaveId;
    Date date;
    double total_amount;
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

}
