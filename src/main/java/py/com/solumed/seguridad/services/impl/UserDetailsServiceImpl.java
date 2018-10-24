package py.com.solumed.seguridad.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.solumed.seguridad.dtos.UserDetailsDTO;
import py.com.solumed.seguridad.entities.UsuarioEntity;
import py.com.solumed.seguridad.entities.UsuarioRoleEntity;
import py.com.solumed.seguridad.repositories.UserRepository;
import py.com.solumed.seguridad.repositories.UserRoleRepository;

/**
 * Created by mcespedes
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepo;


    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepo) {
        this.userRepository = userRepository;
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public UserDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
    	LOG.info("Loading user details: {}", username);

        UsuarioEntity user = userRepository.findOneByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Nombre de usuario no se encuentra " + username));

        List<UsuarioRoleEntity> roles =  userRoleRepo.findByUsuario(user);

        return UserDetailsDTO.builder()
                .username(user.getUsuario())
                .password(user.getPassword())
                .enabled(user.getActivo())
                .grantedAuthorities(this.getGrantedAuthorities(roles))
                .build();
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<UsuarioRoleEntity> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UsuarioRoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }
        return authorities;
    }
}
