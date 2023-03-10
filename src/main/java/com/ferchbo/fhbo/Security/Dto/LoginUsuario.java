
package com.ferchbo.fhbo.Security.Dto;

import javax.validation.constraints.NotBlank;



public class LoginUsuario {
    @NotBlank
    private String nomUsu;
    @NotBlank
    private String password;
    
    //Getters and Setters

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
