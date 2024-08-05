package dev.codex.jwt_practice.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String demo () {
        return "Hello World";
    }

    
}
