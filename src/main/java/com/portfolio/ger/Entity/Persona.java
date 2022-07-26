
package com.portfolio.ger.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String apellido;
       
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String img;

    
    
}
