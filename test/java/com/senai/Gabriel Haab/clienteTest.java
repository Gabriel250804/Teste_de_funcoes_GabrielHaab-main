package com.senai.Haab;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.Haab.domain.Cliente;
import com.senai.Haab.repositories.ClienteRepository;

@SpringBootTest

public class clienteTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Gabriel Haab");
		cli.setCpfOuCnpj("23109212390");
		cli.setEmail("Haab@gmail.com");
		clienteRepository.save(cli);
	}

	@Test
	public void listaCliente() {
		List<Cliente> List = clienteRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		assertEquals("Júlia Alves", cliente.getNome());
	}

	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		cliente.setNome("Gabriel Haab");
		clienteRepository.save(cliente);
		assertNotEquals("Haab"), cliente.getNome());
	}

	@Test
	public void deleteCliente() {
		clienteRepository.deleteById(1);
		assertThat(clienteRepository.existsById(1));
	}

	@Test
	public void somar() {
		double num = 9.0;
		double num2 = 10.0;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num, num2);
		assertEquals(19, soma);
	}

	@Test
	public void subtrair() {
		double num = 10.0;
		double num2 = 8.0;
		Cliente cliente = new Cliente();
		double subtrair = cliente.subtrair(num, num2);
		assertEquals(2.0, subtrair);
	}

	@Test
	public void mutiplicar() {
		double num = 5.0;
		double num2 = 7.0;
		Cliente cliente = new Cliente();
		double mutiplicar = cliente.mutiplicar(num, num2);
		assertEquals(35, mutiplicar);
	}

	@Test
	public void dividir() {
		double num = 25.0;
		double num2 = 5.0;
		Cliente cliente = new Cliente();
		double dividir = cliente.dividir(num, num2);
		assertEquals(5, dividir);
	}
}
