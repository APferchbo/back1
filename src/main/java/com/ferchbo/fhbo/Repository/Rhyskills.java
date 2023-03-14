
package com.ferchbo.fhbo.Repository;

import com.ferchbo.fhbo.Entity.Hyskills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rhyskills extends JpaRepository<Hyskills, Integer>{
    public Optional<Hyskills> findByNomSH(String nomSH);
    public Boolean existsByNomSH(String nomSH);
    
}
