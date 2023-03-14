
package com.ferchbo.fhbo.Repository;

import com.ferchbo.fhbo.Entity.Proyea;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rproyea extends JpaRepository<Proyea,Integer> {
    
    public Optional<Proyea> findByNombreP(String nombreP);
    public Boolean existsByNombreP(String nombreP);
    
}
