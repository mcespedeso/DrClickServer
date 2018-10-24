package py.com.solumed.seguridad.dtos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import py.com.solumed.seguridad.constantes.Role;

import java.util.Collection;
import java.util.List;

/**
 * Created by mcespedes
 */
public class UserDetailsDTO implements UserDetails {

    private final String password;
    private final  String username;
    private final boolean enabled;
    private final List<GrantedAuthority> grantedAuthorities;

    UserDetailsDTO(String username, String password, boolean enabled, List<GrantedAuthority> grantedAuthorities) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetailsDTOBuilder builder() {
        return new UserDetailsDTOBuilder();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public boolean hasRole(Role role) {
        return this.getAuthorities()
                .stream()
                .filter(auth -> Role.valueOf(auth.getAuthority()) == role)
                .count() > 0;
    }
}
