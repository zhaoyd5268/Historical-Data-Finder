package org.jointheleague.api.Historical.Presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    HomeController homeController;

    @BeforeEach
    void setup() {
        homeController = new HomeController();
    }

    @Test
    void whenHome_thenReturnRedirect() {
        //given
        String expected = "redirect:swagger-ui.html";
        //when
        String actual = homeController.home();
        //then
        assertEquals(expected,actual);
    }

}