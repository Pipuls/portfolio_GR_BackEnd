package com.portfolio.ger.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DtoEducacion {
    @NotBlank
    private String tituloE;
    @NotBlank
    private String institucionE;
    @NotBlank
    private String lugarE;
    @NotBlank
    private String anoE;
   
    public DtoEducacion() {
    }

    public DtoEducacion(String tituloE, String institucionE, String lugarE, String anoE) {
        this.tituloE = tituloE;
        this.institucionE = institucionE;
        this.lugarE = lugarE;
        this.anoE = anoE;
    }

}
