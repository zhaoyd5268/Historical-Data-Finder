package org.jointheleague.api.Historical.Service;
import org.jointheleague.api.Historical.Repository.DTO.Result;
import org.jointheleague.api.Historical.Repository.LocRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocServiceTest {

    LocService locService;

    @Mock
    LocRepository locRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        locService = new LocService(locRepository);
    }

    @Test
    public void whenGetResults_thenReturnList() {

        //given
        String query = "java";
        Result result = new Result();
        result.setLink("LINK");
        result.setTitle("TITLE");
        result.setAuthors(Collections.singletonList("AUTHORS"));
        List <Result> expectedResults = Collections.singletonList(result);
        when(locRepository.getResults(query)).thenReturn(expectedResults);


        //when
        List <Result> actualResults = locService.getResults(query);
        //then
        assertEquals(expectedResults,actualResults);

    }


}