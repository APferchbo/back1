
package com.ferchbo.fhbo.Security.Repository;

import com.ferchbo.fhbo.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNomUsu(String nomUsu);

    boolean existsByNomUsu(String nomUsu);

    boolean existsByEmail(String email);
}
