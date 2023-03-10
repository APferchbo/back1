package com.ferchbo.fhbo.Repository;

import com.ferchbo.fhbo.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    
    public Optional<Persona> findByNombre(String nombre);
    public Boolean existsByNombre(String nombre);
    
}