package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entity.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Integer> {
}
