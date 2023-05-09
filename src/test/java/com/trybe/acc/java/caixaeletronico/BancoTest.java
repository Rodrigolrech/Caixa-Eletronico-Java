package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    assertEquals(10, banco.gerarNumeroNovaConta().length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    String nome = "teste";
    String cpf = "123456789121";
    String senha = "123456";
    assertEquals(PessoaCliente, banco.adicionarPessoaCliente(nome,cpf,senha).class());
    assertEquals(1, banco.pessoasClientes.length());
    String nome2 = "teste1";
    String cpf2 = "123456789122";
    String senha2 = "123422";
    banco.adicionarPessoaCliente(nome2,cpf2,senha2);
    assertEquals(2, banco.pessoasClientes.length());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    String nome = "teste";
    String cpf = "123456789121";
    String senha = "123456";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nome,cpf,senha);
    assertEquals(cliente, banco.pessoaClienteLogin(cpf,senha));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    fail("Não implementado");

  }

}
