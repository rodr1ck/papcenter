package com.papcenter.repository;

import com.papcenter.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    Usuario findOneByNombre(String username);
}
