package com.ferchbo.fhbo.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuPrincipal implements UserDetails {

    private String nombre;
    private String nomUsu;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    //Constuctor
    public UsuPrincipal(String nombre, String nomUsu, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nomUsu = nomUsu;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name()))
                .collect(Collectors.toList());

        return new UsuPrincipal(usuario.getNombre(), usuario.getNomUsu(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nomUsu;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
