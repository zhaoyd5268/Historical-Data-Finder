package org.jointheleague.api.Historical.Presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController

public class LocController {

    @GetMapping("/searchLocResults")
    @Operation(summary = "Searches for books",
            description = "Response may include multiple Result values.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result(s) found ",
                    content = {@Content
                            (mediaType="application/json",
                                    schema=@Schema(implementation = Result.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Result(s) not found"),
            @ApiResponse(responseCode = "300", description = "Result(s) not found!")
    })
    public String getResults(@RequestParam(value="q") String query) {
        return ("Looking for interesting literature related to " + query + ". ;)");
    }

}
