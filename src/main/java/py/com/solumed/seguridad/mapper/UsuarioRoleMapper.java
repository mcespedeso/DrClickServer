package py.com.solumed.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.solumed.common.mapper.BaseMapper;
import py.com.solumed.seguridad.dtos.UsuarioRoleDTO;
import py.com.solumed.seguridad.entities.UsuarioRoleEntity;

/**
 *  Created by mcespedes
 */
@Component
public class UsuarioRoleMapper implements BaseMapper<UsuarioRoleEntity, UsuarioRoleDTO> {

	private final ModelMapper modelMapper;
	 
	public UsuarioRoleMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UsuarioRoleDTO> entityListToDtoList(List<UsuarioRoleEntity> entityList) {
		 return entityList.stream()
	                .filter(Objects::nonNull)
	                .map(this::entityToDto)
	                .collect(Collectors.toList());
	}

	@Override
	public UsuarioRoleDTO entityToDto(UsuarioRoleEntity entity) {
		UsuarioRoleDTO dto = modelMapper.map(entity, UsuarioRoleDTO.class);
	    return dto;
	}

	@Override
	public UsuarioRoleEntity dtoToEntity(UsuarioRoleDTO dto) {
		return modelMapper.map(dto, UsuarioRoleEntity.class);
	}

}
