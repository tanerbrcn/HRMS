package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Data listelendi.");
    }

    @Override
    public Result add(Employer employer) {
        if(!getByMail(employer.getEmail())==true){
            return new ErrorResult("zaten sisteme kayıtlısınız");
        }
        employerDao.save(employer);
        return new SuccessResult("Employer bilgisi veritabanına kaydedildi.");
    }

    @Override
    public boolean getByMail(String mail) {
       if(employerDao.getByEmail(mail)==null){
           return true;
       }
       return false;
    }
}
