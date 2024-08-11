package org.jointheleague.api.Historical.Repository;

import org.jointheleague.api.Historical.DTO.LocResponse;
import org.jointheleague.api.Historical.DTO.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocRepositoryTest {

    private LocRepository locRepository;

    @Mock
    WebClient webClient;


    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    WebClient.ResponseSpec responseSpec;

    @Mock
    Mono<LocResponse> locResponseMonoMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        locRepository = new LocRepository(webClient);
    }

    @Test
    public void whengetResults_thenReturnLocResponse() {
        //given
        LocResponse locResponse = new LocResponse();
        String query = "java";
        Result result = new Result();
        result.setLink("LINK");
        result.setTitle("Java: A Drink, an Island, and a Programming Language");
        result.setAuthors(Collections.singletonList("AUTHORS"));
        List<Result> expectedResults = Collections.singletonList(result);
        locResponse.setResults(expectedResults);

        when(webClient.get())
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersSpec.retrieve())
                .thenReturn(responseSpec);
        when(responseSpec.bodyToMono(LocResponse.class))
                .thenReturn(locResponseMonoMock);
        when(locResponseMonoMock.block())
                .thenReturn(locResponse);

        //when
       List<Result> actualResults = locRepository.getResults(query);
        //then
        assertEquals(expectedResults,actualResults);
    }
}