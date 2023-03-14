
package com.ferchbo.fhbo.Repository;

import com.ferchbo.fhbo.Entity.Syskills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rsyskills  extends JpaRepository<Syskills, Integer>{
    
    public Optional<Syskills> findByNomSS(String nomSS);
    public Boolean existsByNomSS(String nomSS);
    
}
    
