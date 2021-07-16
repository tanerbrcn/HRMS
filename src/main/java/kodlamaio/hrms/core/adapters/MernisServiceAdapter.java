package kodlamaio.hrms.core.adapters;

import mernisService.FakeMernisService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserCheckService{
    @Override
    public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName) {
        FakeMernisService client=new FakeMernisService();
        boolean result= client.TCKimlikDogrula(1000000,"Taner","Barçın");
        return result;
    }


}
