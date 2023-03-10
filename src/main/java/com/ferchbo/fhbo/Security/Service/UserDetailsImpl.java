
package com.ferchbo.fhbo.Security.Service;

import com.ferchbo.fhbo.Security.Entity.UsuPrincipal;
import com.ferchbo.fhbo.Security.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nomUsu) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNomUsu(nomUsu).get();
        return UsuPrincipal.build(usuario);
    }
    
    
}
