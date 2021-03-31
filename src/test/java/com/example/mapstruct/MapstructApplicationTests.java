package com.example.mapstruct;

import com.example.mapstruct.dto.UsuarioDto;
import com.example.mapstruct.entity.Area;
import com.example.mapstruct.entity.TipoAcesso;
import com.example.mapstruct.entity.Usuario;
import com.example.mapstruct.mappers.UsuarioMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MapstructApplicationTests {

	Area area;
	Usuario usuario;
	UsuarioDto usuarioDto;

	@BeforeAll
	void build() {
		//Build Area
		area = new Area();
		area.setNome("Financeiro");
		area.setAtiva(true);
		ArrayList<Area> areas = new ArrayList<>();
		areas.add(area);

		//Build Entity
		usuario = new Usuario();
		usuario.setNome("Douglas");
		usuario.setIdade(30);
		usuario.setAreas(areas);
		usuario.setTipoAcesso(TipoAcesso.USER);

		//Build DTO.
		usuarioDto = new UsuarioDto();
		usuarioDto.setNome("Douglas");
		usuarioDto.setIdade(30);
	}

	@Test
	@DisplayName("Convertendo entity em DTO")
	void convertendoEntityEmDto() {
		UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.toUsuarioDto(usuario);
		Assertions.assertEquals(usuario.getNome(), usuarioDto.getNome());
		Assertions.assertEquals(usuario.getIdade(), usuarioDto.getIdade());
		Assertions.assertEquals(usuario.getAreas().get(0).getNome(), usuarioDto.getAreas().get(0).getNome());
	}

	@Test
	@DisplayName("Convertendo DTO em entity")
	void convertendoDtoEmEntity() {
		Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDto);
		Assertions.assertEquals(usuarioDto.getNome(), usuario.getNome());
		Assertions.assertEquals(usuarioDto.getIdade(), usuario.getIdade());
	}
}
