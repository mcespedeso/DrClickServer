package py.com.solumed.seguridad.services.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMultimap;

import py.com.solumed.common.exceptions.CustomParameterizedException;
import py.com.solumed.common.exceptions.UnknownResourceException;
import py.com.solumed.seguridad.dtos.UsuarioDTO;
import py.com.solumed.seguridad.entities.UsuarioEntity;
import py.com.solumed.seguridad.mapper.UsuarioMapper;
import py.com.solumed.seguridad.repositories.UserRepository;
import py.com.solumed.seguridad.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

//    private UserRoleRepository userRoleRepository;

    private final UsuarioMapper userMapper;

//    private final I18n i18n;

    public UserServiceImpl(UserRepository userRepository,
                           UsuarioMapper userMapper) {
        this.userRepository = userRepository;
//        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;

    }

    @Override
    public UsuarioDTO addUser(UsuarioDTO usuarioDTO) {
        userRepository
                .findOneByUsuario(usuarioDTO.getUsuario())
                .ifPresent(user -> {
                    throw new CustomParameterizedException("El usuario ya existe.",
                            new ImmutableMultimap.Builder<String, String>()
                                    .put("username", user.getUsuario())
                                    .build()
                                    .asMap());
                });
        UsuarioEntity user = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, user);
        UsuarioEntity newUser = userRepository.save(user);
        return userMapper.entityToDto(newUser);
    }

    @Override
    public UsuarioDTO getUserById(Long userId) {
        checkArgument(userId > 0, "Argument was %s but expected nonnegative", userId);
        
        Optional<UsuarioEntity> userOptional = userRepository.findById(userId);

        return userOptional.map(userMapper::entityToDto)
                .orElseThrow(() -> new UnknownResourceException("No se encuentra el usuario con id " + userId));
        
    }

//    private UsuarioRoleEntity createUserRole(UsuarioEntity user, Role role) {
//        UsuarioRoleEntity userRole = new UsuarioRoleEntity();
//        userRole.setUsuario(user);
//        userRole.setRole(role);
//        return userRoleRepository.save(userRole);
//    }

    @Override
    public List<UsuarioDTO> getAllUsers() {
        List<UsuarioEntity> users = userRepository.findAll();
        return userMapper.entityListToDtoList(users);
    }

    @Override
    public void deleteUser(Long userId) {
//        checkArgument(userId > 0, "Argument was %s but expected nonnegative", userId);
//
//        Optional.ofNullable(
//                userRepository.findOne(userId))
//                .ifPresent(user -> {
//                    user.setActivo(false);
//                    userRepository.save(user);
//                    LOG.debug("Deleted User: {}", user);
//                });
    }

   

    @Override
    public UsuarioDTO updateUser(Long userId, UsuarioDTO userDTO) {
        checkArgument(userId > 0, "Argument was %s but expected nonnegative", userId);

        return Optional.ofNullable(
                userRepository.findById(userId).get())
                .map(user -> {
                    BeanUtils.copyProperties(userDTO, user);
                    LOG.debug("Changed Information for User: {}", user);
                    return user;
                })
                .map(userMapper::entityToDto)
                .orElseThrow(() -> new UnknownResourceException("User does not exist"));
    }

}