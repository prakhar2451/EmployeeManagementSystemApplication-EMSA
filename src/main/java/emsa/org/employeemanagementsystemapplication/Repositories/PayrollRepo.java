package emsa.org.employeemanagementsystemapplication.Repositories;

import emsa.org.employeemanagementsystemapplication.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepo extends JpaRepository<Payroll, Integer> {
}
