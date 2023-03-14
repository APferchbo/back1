
package com.ferchbo.fhbo.Dto;

import javax.validation.constraints.NotBlank;


public class Dtosyskills {
    
    @NotBlank
    private String nomSS;
    @NotBlank
    private int porSS;
    @NotBlank
    private String imgSS;
    
    //Constructor

    public Dtosyskills() {
    }

    public Dtosyskills(String nomSS, int porSS, String imgSS) {
        this.nomSS = nomSS;
        this.porSS = porSS;
        this.imgSS = imgSS;
    }
    
    //Getters and setters

    public String getNomSS() {
        return nomSS;
    }

    public void setNomSS(String nomSS) {
        this.nomSS = nomSS;
    }

    public int getPorSS() {
        return porSS;
    }

    public void setPorSS(int porSS) {
        this.porSS = porSS;
    }

    public String getImgSS() {
        return imgSS;
    }

    public void setImgSS(String imgSS) {
        this.imgSS = imgSS;
    }

   
    
    
}
