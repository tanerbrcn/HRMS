package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entity.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionManager implements PositionService {


    private PositionDao positionDao;
    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }


    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(positionDao.findAll(),"Data listelendi.");
    }

    @Override
    public Result add(Position position) {
        positionDao.save(position);
        return new SuccessResult("Pozisyon bilgisi veritabanına kaydedildi.");
    }
}
