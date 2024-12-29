package com.example.jenkinsgreetingproject;

        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;

        import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGetGreeting() {
        String result = greetingService.getGreeting("Alice");
        assertEquals("Bonjour, Alice ! Bienvenue dans notre service de salutation.", result);
    }
}