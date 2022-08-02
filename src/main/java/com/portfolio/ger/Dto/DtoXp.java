package com.portfolio.ger.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//Getters y Setters
@Getter @Setter
public class DtoXp {
    @NotBlank
    private String puestoE;
    @NotBlank
    private String anoE;
    @NotBlank
    private String empresaE;
    @NotBlank
    private String descripcionE;
    
    //Constructor

    public DtoXp() {
    }

    public DtoXp(String puestoE, String añoE, String empresaE, String descripcionE) {
        this.puestoE = puestoE;
        this.anoE = anoE;
        this.empresaE = empresaE;
        this.descripcionE = descripcionE;
    }
    
    
}
