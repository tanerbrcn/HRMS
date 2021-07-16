package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.adapters.UserEmailVerificationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entity.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserCheckService check;
    private UserEmailVerificationService emailVerification;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,UserCheckService check,UserEmailVerificationService emailVerification) {
        this.candidateDao = candidateDao;
        this.check = check;
        this.emailVerification=emailVerification;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Candidate candidate) {
    if(!check.checkIfRealPerson(Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName(),candidate.getLastName()) == true){
        return new ErrorResult("Mernis doğrulama hatası!");
    }

    if (!candidate.getPassword().equals(candidate.getPasswordRepeat())==true)
    {
        return new  ErrorResult("Parola ve parola tekrarı uyuşmuyor.");
    }


    if(!emailVerification.checkIfEmailVerification(candidate.getEmail())==true){
        return new ErrorResult("email doğrulaması yanlış");
    }

        if(!getByNationalIdentity(candidate.getNationalIdentity())==true){
            return new ErrorResult("zaten sisteme kayıtlısınız");
        }

        candidateDao.save(candidate);
        return new SuccessResult("Candidate bilgisi veritabanına kaydedildi.");
    }

    @Override
    public boolean getByNationalIdentity(String tc) {
        if(candidateDao.getByNationalIdentity(tc)==null){
            return true;
        }
        return false;
    }


}
