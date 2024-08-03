package Repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository

public class locRepository {

    public final WebClient webClient;

    private static final String baseUrl = "https://www.loc.gov/books";

    public locRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }
    public String getResults(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("fo", "json")
                        .queryParam("at", "results")
                        .queryParam("q", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
