package emsa.org.employeemanagementsystemapplication.Repositories;

import emsa.org.employeemanagementsystemapplication.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepo extends JpaRepository<Qualification, Integer> {
}
