package py.com.solumed.seguridad.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.solumed.common.mapper.BaseMapper;
import py.com.solumed.seguridad.dtos.UsuarioDTO;
import py.com.solumed.seguridad.entities.UsuarioEntity;
import py.com.solumed.seguridad.repositories.UserRoleRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mcespedes
 */
@Component
public class UsuarioMapper implements BaseMapper<UsuarioEntity, UsuarioDTO> {


    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;

    public UsuarioMapper(ModelMapper modelMapper, UserRoleRepository userRoleRepository) {
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<UsuarioDTO> entityListToDtoList(List<UsuarioEntity> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO entityToDto(UsuarioEntity entity) {
        UsuarioDTO dto = modelMapper.map(entity, UsuarioDTO.class);
        dto.setPassword(null);
        //dto.setRole(this.userRoleRepository.findById(entity.getId()).get().getRole().getSecurityName());
        return dto;
    }

    @Override
    public UsuarioEntity dtoToEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, UsuarioEntity.class);
    }
}
