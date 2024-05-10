package com.jhon.backend.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "Health check")
public class healthController {
    @Operation(summary = "Health check")
    @GetMapping("")
    public ResponseEntity<?> getHealth() {
        return ResponseEntity.ok("OK");
    }
}
