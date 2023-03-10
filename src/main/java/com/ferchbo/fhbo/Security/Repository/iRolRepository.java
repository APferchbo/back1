
package com.ferchbo.fhbo.Security.Repository;

import com.ferchbo.fhbo.Security.Entity.Rol;
import com.ferchbo.fhbo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
