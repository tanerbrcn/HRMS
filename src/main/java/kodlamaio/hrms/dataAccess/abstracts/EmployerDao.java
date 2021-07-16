package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entity.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getByEmail(String mail);
}
