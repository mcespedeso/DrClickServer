package py.com.solumed.seguridad.constantes;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Role {
	/**
	 * Puede hacer de todo
	 */
	ADMIN,

	/**
	 * Puede manejar todo lo que se refiere a servicios del medico
	 */
	MEDICO,

	/**
	 * Puede manejar todo lo que se refiere a servicios de secretaria
	 */
	SECRETARIA,

	/**
	 * Puede manejar todo lo que se refiere a los servicios del paciente
	 */
	PACIENTE,


	/**
	 * Maneja servicios basicos para el usuario
	 */
	USER;

	private static final String SEPARATOR = "_";
	private static final String PREFIX = "ROLE";

	/**
	 * Returns the name of this enum value without the {@link #PREFIX}.
	 * Spring security works with role names without this prefix.
	 *
	 * @return
	 */
	public String getSecurityName() {
		return Arrays.stream(this.name().split(SEPARATOR))
				.filter(part -> !part.equals(PREFIX))
				.collect(Collectors.joining(SEPARATOR));
	}
}