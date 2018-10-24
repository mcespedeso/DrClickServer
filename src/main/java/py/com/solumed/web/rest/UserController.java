package py.com.solumed.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.solumed.seguridad.dtos.UsuarioDTO;
import py.com.solumed.seguridad.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> agregarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        UsuarioDTO result = userService.addUser(usuarioDTO);
        return ResponseEntity
                .created(new URI("/api/v1/users/" + result.getIdUsuario()))
                .body(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("userId") Long userId) {
        UsuarioDTO dto = userService.getUserById(userId);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable("userId") Long userId) {
        LOG.debug("REST request to delete User: {}", userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping()
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        List<UsuarioDTO> usuarios = userService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }
}