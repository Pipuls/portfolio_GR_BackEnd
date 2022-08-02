package com.portfolio.ger.Controller;

import com.portfolio.ger.Dto.DtoEducacion;
import com.portfolio.ger.Entity.Educacion;
import com.portfolio.ger.Security.Controller.Mensaje;
import com.portfolio.ger.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    //Metodos
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id especificado"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion){
         if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getInstitucionE())){
            return new ResponseEntity(new Mensaje("La institución es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getLugarE())){
            return new ResponseEntity(new Mensaje("El lugar es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if(StringUtils.isBlank(dtoeducacion.getAnoE())){
            return new ResponseEntity(new Mensaje("El año es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByTituloE (dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("Ese título ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
               dtoeducacion.getTituloE(), dtoeducacion.getInstitucionE(), 
                dtoeducacion.getLugarE(), dtoeducacion.getAnoE()
            );
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("La educación se creó correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion){
        if (!sEducacion.existsById(id)){
           return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if (sEducacion.existsByTituloE(dtoEducacion.getTituloE()) && sEducacion.getByTituloE(dtoEducacion.getTituloE()) 
                .get() .getId() !=id){
            return new ResponseEntity(new Mensaje("Ese título ya existe"), HttpStatus.BAD_REQUEST); 
        }
        //agregar los if que faltan de institucion lugar y año
        if (StringUtils.isBlank(dtoEducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        //agregar los blank de los campos institucion lugar y año
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setTituloE(dtoEducacion.getTituloE());
        educacion.setInstitucionE(dtoEducacion.getInstitucionE());
        educacion.setLugarE(dtoEducacion.getLugarE()); 
        educacion.setAnoE(dtoEducacion.getAnoE());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("La educación se actualizó correctamente"), HttpStatus.OK);
    }
}
