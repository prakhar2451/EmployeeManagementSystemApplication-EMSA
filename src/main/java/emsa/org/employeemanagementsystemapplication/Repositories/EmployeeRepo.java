package emsa.org.employeemanagementsystemapplication.Repositories;

import emsa.org.employeemanagementsystemapplication.entities.Department;
import emsa.org.employeemanagementsystemapplication.entities.Employee;
import emsa.org.employeemanagementsystemapplication.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Department department);
    List<Employee> findByQualification(Qualification qualification);
}
