/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferchbo.fhbo.Dto;

import javax.validation.constraints.NotBlank;



public class Dtohyskills {
    
    @NotBlank
    private String nomS;
    @NotBlank
    private int porS;
    
    //constructor

    public Dtohyskills() {
    }

    public Dtohyskills(String nomS, int porS) {
        this.nomS = nomS;
        this.porS = porS;
    }
    
    //getters and setters

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public int getPorS() {
        return porS;
    }

    public void setPorS(int porS) {
        this.porS = porS;
    }
    
    
    
}
