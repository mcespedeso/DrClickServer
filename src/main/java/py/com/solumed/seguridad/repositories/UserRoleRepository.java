package py.com.solumed.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.solumed.seguridad.entities.UsuarioEntity;
import py.com.solumed.seguridad.entities.UsuarioRoleEntity;

/**
 * Created by mcespedes
 */
public interface UserRoleRepository
        extends JpaRepository<UsuarioRoleEntity, Long> {

    List<UsuarioRoleEntity> findByUsuario(UsuarioEntity usuario);

    UsuarioRoleEntity findByUsuarioId(Long idUsuario);
}