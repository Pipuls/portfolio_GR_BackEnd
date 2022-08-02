package com.portfolio.ger.Repository;

import com.portfolio.ger.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    
    //Metodos propios
    public Optional<Educacion> findByTituloE (String tituloE);
    public boolean existsByTituloE(String tituloE);
}
