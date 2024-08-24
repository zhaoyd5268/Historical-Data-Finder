package org.jointheleague.api.Historical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class ApiDocConfig {
//asdf
  /*  private ApiInfo apiInfo() {
        return new ApiInfo(
                "Level 7 Historical Data Finder",
                "League of Amazing Programmers Level 7 Historical Data Finder",
                "1.0.0",
                null,
                new Contact("Daniel Zhao", "www.jointheleague.org", "zhaoyd5268@gmail.com"),
                null, null, Collections.emptyList());
    }

    @Bean
     public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    } */

    @Bean
    public OpenAPI usersMicrosServiceAPI () {
        return new OpenAPI();
    }
}
