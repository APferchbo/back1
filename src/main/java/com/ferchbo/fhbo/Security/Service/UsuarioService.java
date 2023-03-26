package com.ferchbo.fhbo.Security.Service;

import com.ferchbo.fhbo.Security.Entity.Usuario;
import com.ferchbo.fhbo.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNomUsu(String nomUsu) {
        return iusuarioRepository.findByNomUsu(nomUsu);
    }

    public Boolean existsByNomUsu(String nomUsu) {
        return iusuarioRepository.existsByNomUsu(nomUsu);
    }

    public Boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
