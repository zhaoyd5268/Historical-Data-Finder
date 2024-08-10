package org.jointheleague.api.Historical.Service;

import org.jointheleague.api.Historical.DTO.Result;
import org.jointheleague.api.Historical.Repository.LocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocService {

    private final LocRepository locRepository;

    public LocService(LocRepository locRepository) {
        this.locRepository = locRepository;
    }

    public List<Result> getResults(String query) {
        return locRepository.getResults(query);
    }


}
