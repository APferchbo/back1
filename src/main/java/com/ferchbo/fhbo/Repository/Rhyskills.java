
package com.ferchbo.fhbo.Repository;

import com.ferchbo.fhbo.Entity.hyskills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rhyskills extends JpaRepository<hyskills, Integer>{
    public Optional<hyskills> findByNomS(String nomS);
    public Boolean existsByNomS(String nomS);
    
}
