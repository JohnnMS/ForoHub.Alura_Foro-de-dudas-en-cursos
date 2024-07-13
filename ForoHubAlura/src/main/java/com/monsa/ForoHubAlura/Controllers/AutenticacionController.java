package com.monsa.ForoHubAlura.Controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monsa.ForoHubAlura.Models.Usuarios.DTODatosAutenticacion;
import com.monsa.ForoHubAlura.Models.Usuarios.JPAUsuarios;
import com.monsa.ForoHubAlura.Secure.DTODatosTokenJWT;
import com.monsa.ForoHubAlura.Secure.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacionController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DTODatosTokenJWT> realizarLogin(@RequestBody @Valid DTODatosAutenticacion datos) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.usuario(), datos.clave());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((JPAUsuarios) authentication.getPrincipal());
        return ResponseEntity.ok(new DTODatosTokenJWT(tokenJWT));
    }

}