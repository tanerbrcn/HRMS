package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entity.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
