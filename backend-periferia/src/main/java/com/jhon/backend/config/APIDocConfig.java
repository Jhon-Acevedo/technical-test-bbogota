package com.jhon.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(info =
@Info(
        title = "Backend API Periferia IT",
        version = "1.0",
        description = "Documentation of backend API v1.0"
)
)
public class APIDocConfig {
}
