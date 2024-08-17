package org.jointheleague.api.Historical;

import org.jointheleague.api.Historical.DTO.Result;
import org.jointheleague.api.Historical.Presentation.LocController;
import org.jointheleague.api.Historical.Service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocController.class)

public class LocControllerIntTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LocService locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        LocController locController = new LocController(locService);
    }



    @Test
    public void givenGoodQuery_whenSearchingForResults_thenIsOkAndReturnResults() throws Exception {
        //given
        String query = "Java";
        Result result = new Result();
        result.setTitle("Java:A Drink, an Island, and a Programming Language");
        result.setLink("LINK");
        result.setAuthors(Collections.singletonList("AUTHORS"));
        List<Result> expectedResults = Collections.singletonList(result);

        when(locService.getResults(query)).thenReturn(expectedResults);
        //when

        //then
        MvcResult mvcResult = mockMvc.perform(get("/searchLocResults?q="+query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

}
