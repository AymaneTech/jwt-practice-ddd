package dev.codex.jwt_practice.common.models;


import java.util.Map;

public record ErrorResponse(int status, String message, Map<String, String> errors) {}
