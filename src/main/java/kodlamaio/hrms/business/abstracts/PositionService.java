package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entity.concretes.Position;

import java.util.List;

public interface PositionService {

    DataResult<List<Position>> getAll();
    Result add(Position position);
}