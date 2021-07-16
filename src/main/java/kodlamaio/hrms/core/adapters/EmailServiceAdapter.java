package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.emailService.FakeEmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceAdapter implements UserEmailVerificationService{

    @Override
    public boolean checkIfEmailVerification(String email) {

        FakeEmailService client=new FakeEmailService();
        boolean result=client.EmailVerification(email);
        return result;
    }
}
