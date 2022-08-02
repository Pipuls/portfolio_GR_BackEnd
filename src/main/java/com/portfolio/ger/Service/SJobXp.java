
package com.portfolio.ger.Service;

import com.portfolio.ger.Entity.JobXp;
import com.portfolio.ger.Repository.RJobXp;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SJobXp {
    @Autowired
    RJobXp rJobXp;
    
    //metodos
    public List<JobXp> list(){
        return rJobXp.findAll();
    }
    
    public Optional<JobXp> getOne(int id){
        return rJobXp.findById(id);
    }
    
    public Optional<JobXp> getByEmpresaE(String empresaE){
        return rJobXp.findByEmpresaE(empresaE);
    }
    
    public void save(JobXp expe){
        rJobXp.save(expe);
    }
    
    public void delete(int id){
        rJobXp.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rJobXp.existsById(id);
    }
    
    public boolean existByEmpresaE(String empresaE){
        return rJobXp.existsByEmpresaE(empresaE);
    }
}
