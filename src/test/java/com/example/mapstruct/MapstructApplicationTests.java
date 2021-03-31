package com.example.mapstruct;

import com.example.mapstruct.dto.UsuarioDto;
import com.example.mapstruct.entity.TipoAcesso;
import com.example.mapstruct.entity.Usuario;
import com.example.mapstruct.mappers.UsuarioMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MapstructApplicationTests {

	Usuario usuario;
	UsuarioDto usuarioDto;

	@BeforeAll
	void build() {
		//Build Entity
		usuario = new Usuario();
		usuario.setNome("Douglas");
		usuario.setIdade(30);
		usuario.setTipoAcesso(TipoAcesso.USER);
		//Build DTO.
		usuarioDto = new UsuarioDto();
		usuarioDto.setNome("Douglas");
		usuarioDto.setIdade(30);
	}

	@Test
	@DisplayName("Convertendo bean em DTO")
	void convertendoBeanEmDto() {
		UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.toUsuarioDto(usuario);
		Assertions.assertEquals(usuario.getNome(), usuarioDto.getNome());
		Assertions.assertEquals(usuario.getIdade(), usuarioDto.getIdade());
	}

	@Test
	@DisplayName("Convertendo DTO em bean")
	void convertendoDtoEmBean() {
		Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDto);
		Assertions.assertEquals(usuarioDto.getNome(), usuario.getNome());
		Assertions.assertEquals(usuarioDto.getIdade(), usuario.getIdade());
	}
}
