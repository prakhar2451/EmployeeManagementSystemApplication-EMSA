package emsa.org.employeemanagementsystemapplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qualId;
    private String position;
    private String requirements;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;


}
