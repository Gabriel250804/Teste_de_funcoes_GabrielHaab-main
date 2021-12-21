package com.senai.Haab.;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.senai.Haab.domain.Estado;
import com.senai.Haab.repositories.EstadoRepository;

@SpringBootTest
public class estadoTest {
	@Autowired
	EstadoRepository estadoRepository;

	@Test
	void Estado() {
		Estado est1 = new Estado();
		est1.setId(null);
		;
		est1.setNome("Minas Gerais");
		est1.setCidades(null);
		estadoRepository.save(est1);
	}

	@Test
	public void listaEstado() {
		List<Estado> List = estadoRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idEstado() {
		Estado estado = estadoRepository.findById(1).get();
		assertEquals("Minas Gerais", estado.getNome());
	}

	@Test
	public void updateEstado() {
		Estado estado = estadoRepository.findById(1).get();
		estado.setNome("Minas Gerais");
		estadoRepository.save(estado);
		assertNotEquals("MG", estado.getNome());
	}

	@Test
	public void deleteEstado() {
		estadoRepository.deleteById(1);
		assertThat(estadoRepository.existsById(1));
	}
}