package py.com.solumed.seguridad.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import py.com.solumed.common.entities.BaseEntity;
import py.com.solumed.seguridad.constantes.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_x_role", schema = "seguridad")
public class UsuarioRoleEntity extends BaseEntity {

	@Id
	@GenericGenerator(
			name = "usuarioRolesSequenceGenerator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = SequenceStyleGenerator.SCHEMA,
					        value = "seguridad"),
					@Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
					        value = "usuario_x_role_id_usuario_x_role_seq"),
					@Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
					        value = "1"),
					@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
					        value = "1")
			}
	)
	@GeneratedValue(generator = "usuarioRolesSequenceGenerator")
	@Column(name = "id_usuario_x_role")
	private Long id;

	@ManyToOne(targetEntity = UsuarioEntity.class)
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;

	@Column(name = "role")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UsuarioRoleEntity [id=" + id + ", user=" + usuario + ", role=" + role + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		UsuarioRoleEntity toCompare = (UsuarioRoleEntity) obj;
		return id.equals(toCompare.id);
	}
	
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
	
}
