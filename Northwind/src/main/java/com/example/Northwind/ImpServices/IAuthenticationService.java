package com.example.Northwind.ImpServices;

import com.example.Northwind.Security.AuthenticationRequest;
import com.example.Northwind.Security.AuthenticationResponse;
import com.example.Northwind.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class IAuthenticationService implements AuthenticationService {

    @Autowired
    AuthenticationManager authManager;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authReq) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword());
        authManager.authenticate(authToken);

        return null;
    }
}
