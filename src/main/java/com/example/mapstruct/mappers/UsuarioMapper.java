package com.example.mapstruct.mappers;

import com.example.mapstruct.dto.UsuarioDto;
import com.example.mapstruct.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioDto dto);
    UsuarioDto toUsuarioDto(Usuario entity);
}
