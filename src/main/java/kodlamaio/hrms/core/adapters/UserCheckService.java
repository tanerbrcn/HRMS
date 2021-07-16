package kodlamaio.hrms.core.adapters;

public interface UserCheckService {
    boolean checkIfRealPerson(long nationalityId, String firstName, String lastName);
}
