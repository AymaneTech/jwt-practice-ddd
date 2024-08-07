package dev.codex.jwt_practice.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.RegisterRequest;
import dev.codex.jwt_practice.User.Application.UserService;
import dev.codex.jwt_practice.User.Domain.User;
import lombok.RequiredArgsConstructor;

/**
 * DemoController
 */
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final UserService service;

    @GetMapping("/hello")
    public String demo() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String demo2() {
        return "Hello World 2";
    }

    @PostMapping("createUser")
    public User create(@RequestBody RegisterRequest request) {
        return service.save(request);
    }

}
