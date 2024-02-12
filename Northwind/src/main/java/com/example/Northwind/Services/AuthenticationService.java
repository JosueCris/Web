package com.example.Northwind.Services;

import com.example.Northwind.Security.AuthenticationRequest;
import com.example.Northwind.Security.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authReq);
}
