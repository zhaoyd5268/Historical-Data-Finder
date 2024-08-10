package org.jointheleague.api.Historical.Presentation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller

@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }

}

