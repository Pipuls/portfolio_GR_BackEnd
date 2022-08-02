package com.portfolio.ger.Controller;

import com.portfolio.ger.Dto.DtoXp;
import com.portfolio.ger.Entity.JobXp;
import com.portfolio.ger.Security.Controller.Mensaje;
import com.portfolio.ger.Service.SJobXp;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CJobXp {

    @Autowired
    SJobXp sJobXp;

    @GetMapping("/lista")
    public ResponseEntity<List<JobXp>> list() {
        List<JobXp> list = sJobXp.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<JobXp> getById(@PathVariable("id") int id) {
        if (!sJobXp.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id especificado"), HttpStatus.NOT_FOUND);
        }
        JobXp jobxp = sJobXp.getOne(id).get();
        return new ResponseEntity(jobxp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sJobXp.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sJobXp.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoXp dtoexp
    ) {
        if (StringUtils.isBlank(dtoexp.getEmpresaE())) {
            return new ResponseEntity(new Mensaje("El campo de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sJobXp.existByEmpresaE(dtoexp.getEmpresaE())) {
            return new ResponseEntity(new Mensaje("Esa empresa existe"), HttpStatus.BAD_REQUEST);
        }

        JobXp jobXp = new JobXp(dtoexp.getPuestoE(), dtoexp.getAnoE(), dtoexp.getEmpresaE(), dtoexp.getDescripcionE());
        sJobXp.save(jobXp);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoXp dtoXp
    ) {
        //Vallidamos si existe el ID
        if (!sJobXp.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sJobXp.existByEmpresaE(dtoXp.getEmpresaE()) && sJobXp.getByEmpresaE(dtoXp.getEmpresaE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        //el campo no puede estar vacio
        if (StringUtils.isBlank(dtoXp.getEmpresaE())) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        JobXp jobXp = sJobXp.getOne(id).get();
        jobXp.setPuestoE(dtoXp.getPuestoE());
        jobXp.setAnoE(dtoXp.getAnoE());
        jobXp.setEmpresaE(dtoXp.getEmpresaE());
        jobXp.setDescripcionE(dtoXp.getDescripcionE());

        sJobXp.save(jobXp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

}
