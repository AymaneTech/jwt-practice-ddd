package dev.codex.jwt_practice.Authentication.Interfaces.Web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.LoginRequest;
import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.RegisterRequest;
import dev.codex.jwt_practice.Authentication.Application.DTOs.Responses.AuthenticationResponse;
import dev.codex.jwt_practice.Authentication.Application.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;

/**
 * AuthController
 */
@RestController
@RequestMapping("api/v1/auth")

@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(
                service.register(request));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                service.login(request));
    }
}
