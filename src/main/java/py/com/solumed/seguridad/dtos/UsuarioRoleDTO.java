package py.com.solumed.seguridad.dtos;

import com.google.common.base.MoreObjects;

import py.com.solumed.seguridad.constantes.Role;

public class UsuarioRoleDTO {

	private Long userRoleId;

	private UsuarioDTO user;

	private Role role;
	
	public UsuarioRoleDTO(){}
	
	private UsuarioRoleDTO(Long userRoleId, UsuarioDTO user, Role role) {
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}
	
	public static class Builder {
		private Long userRoleId;
		private UsuarioDTO user;
		private Role role;
		
		public Builder userRoleId(Long userRoleId) {
			this.userRoleId = userRoleId;
			return this;
		}
		
		public Builder user(UsuarioDTO user) {
			this.user = user;
			return this;
		}
		
		public Builder role(Role role) {
			this.role = role;
			return this;
		}
		
		public UsuarioRoleDTO build() {
			return new UsuarioRoleDTO(userRoleId, user, role);
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UsuarioDTO getUser() {
		return user;
	}

	public void setUser(UsuarioDTO user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("userRoleId", userRoleId)
				.add("user", user)
				.add("role", role)
				.toString();
	}

}
