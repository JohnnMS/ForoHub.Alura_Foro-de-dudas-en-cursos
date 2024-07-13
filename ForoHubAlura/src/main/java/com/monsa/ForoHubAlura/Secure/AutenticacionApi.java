package com.monsa.ForoHubAlura.Secure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monsa.ForoHubAlura.Models.Usuarios.iUsuariosRepository;

@Service
public class AutenticacionApi implements UserDetailsService{

    private final iUsuariosRepository usuariosRepository;

    public AutenticacionApi(iUsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return usuariosRepository.findByUsuario(usuario);
    }

}
