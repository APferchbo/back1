
package com.ferchbo.fhbo.Dto;

import javax.validation.constraints.NotBlank;



public class Dtohyskills {
    
    @NotBlank
    private String nomSH;
    @NotBlank
    private int porSH;
    @NotBlank
    private String img;
    
    //Constructor

    public Dtohyskills() {
    }

    public Dtohyskills(String nomSH, int porSH, String img) {
        this.nomSH = nomSH;
        this.porSH = porSH;
        this.img = img;
    }

    //Getters and setters

    public String getNomSH() {
        return nomSH;
    }

    public void setNomSH(String nomSH) {
        this.nomSH = nomSH;
    }

    public int getPorSH() {
        return porSH;
    }

    public void setPorSH(int porSH) {
        this.porSH = porSH;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
