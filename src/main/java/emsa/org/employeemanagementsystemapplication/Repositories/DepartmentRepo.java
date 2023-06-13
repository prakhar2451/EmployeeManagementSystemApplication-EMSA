package emsa.org.employeemanagementsystemapplication.Repositories;

import emsa.org.employeemanagementsystemapplication.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
