package Service;

import Repository.locRepository;
import org.springframework.stereotype.Service;

@Service

public class locService {

   private final locRepository locRepository;

    public locService(locRepository locRepository) {
        this.locRepository = locRepository;
    }


    public String getResults(String query) {
        return "Searching for literature related to " + query + "...";
    }


}
