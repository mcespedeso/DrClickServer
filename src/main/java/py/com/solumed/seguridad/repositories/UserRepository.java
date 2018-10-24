package py.com.solumed.seguridad.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import py.com.solumed.seguridad.entities.UsuarioEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by mcespedes
 */
public interface UserRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findOneByUsuario(String usuario);

    UsuarioEntity findByUsuario(String username);

    Page<UsuarioEntity> findAll(Pageable page);

    List<UsuarioEntity> findAll();
    
}