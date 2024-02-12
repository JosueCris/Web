package com.example.Northwind.Controllers;

import com.example.Northwind.Security.AuthenticationRequest;
import com.example.Northwind.Security.AuthenticationResponse;
import com.example.Northwind.Services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/northwind/api/v1")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authReq) {
        AuthenticationResponse jwtResp = this.service.login(authReq);
        return ResponseEntity.ok(jwtResp);
    }

    @GetMapping("/public-access")
    public String getAccess() {
        return "This endpoint is public ^^";
    }

}
