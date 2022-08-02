package com.portfolio.ger.Repository;

import com.portfolio.ger.Entity.JobXp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RJobXp extends JpaRepository<JobXp, Integer>{
    
    //metodos propios
    public Optional<JobXp> findByEmpresaE(String empresaE);
        public boolean existsByEmpresaE(String empresaE);
}
