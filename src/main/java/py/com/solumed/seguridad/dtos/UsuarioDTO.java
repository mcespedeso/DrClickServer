package py.com.solumed.seguridad.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;

    @NotNull
    private String usuario;

    private String password;

    private Boolean activo;

    public UsuarioDTO() {
    }

    private UsuarioDTO(Long idUsuario, String usuario, String password,
            Boolean activo, String role) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.activo = activo;
    }

    public static class Builder {
        private Long idUsuario;
        private String usuario;
        private String password;
        private boolean active;
        private String role;

        public Builder idUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public UsuarioDTO build() {
            return new UsuarioDTO(idUsuario, usuario, password, active, role);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUsuario", idUsuario)
                .add("usuario", usuario)
                .add("password", password)
                .add("activo", activo).toString();
    }
}
