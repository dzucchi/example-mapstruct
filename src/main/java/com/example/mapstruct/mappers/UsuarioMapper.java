package com.example.mapstruct.mappers;

import com.example.mapstruct.dto.UsuarioDto;
import com.example.mapstruct.entity.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioDto dto);

    UsuarioDto toUsuarioDto(Usuario entity);

    @IterableMapping(elementTargetType = UsuarioDto.class)
    List<Usuario> toListUsuario(Iterable<UsuarioDto> dtos);

    @IterableMapping(elementTargetType = Usuario.class)
    List<UsuarioDto> toListUsuarioDto(Iterable<Usuario> entities);
}
