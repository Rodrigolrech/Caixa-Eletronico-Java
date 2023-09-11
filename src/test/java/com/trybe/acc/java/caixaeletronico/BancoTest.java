package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String conta = banco.gerarNumeroNovaConta();
    Assertions.assertEquals(10, conta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    String nome = "teste";
    String cpf = "123456789121";
    String senha = "123456";
    Assertions.assertEquals(PessoaCliente.class,
        banco.adicionarPessoaCliente(nome,cpf,senha).getClass());
    Assertions.assertEquals(1, banco.getPessoasClientes().size());
    String nome2 = "teste1";
    String cpf2 = "123456789122";
    String senha2 = "123422";
    banco.adicionarPessoaCliente(nome2,cpf2,senha2);
    Assertions.assertEquals(2, banco.getPessoasClientes().size());
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    String nome = "teste";
    String cpf = "123456789121";
    String senha = "123456";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nome,cpf,senha);
    Assertions.assertEquals(cliente, banco.pessoaClienteLogin(cpf,senha));
  }
/*
Testar saídas console
https://cursos.alura.com.br/forum/topico-testando-saida-no-console-71576
 */
  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    String nomeDeposito = "vaiDepositar";
    String cpf = "123456789121";
    String senha = "123456";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nomeDeposito,cpf,senha);
    Conta contaCorrente = new Conta("Corrente", cliente, banco);
    Conta contaPoupanca = new Conta("Poupança", cliente, banco);
    banco.depositar(cliente, 1, 5000);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    Assertions.assertTrue(output.toString().contains("5000"));
    banco.mostrarExtrato(cliente, 1);
    Assertions.assertTrue(output.toString().contains("5000"));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    String nomeDeposito = "vaiDepositar";
    String cpf = "123456789121";
    String senha = "123456";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nomeDeposito,cpf,senha);
    Conta contaCorrente = new Conta("Corrente", cliente, banco);
    Conta contaPoupanca = new Conta("Poupança", cliente, banco);
    banco.depositar(cliente, 1, 5000);
    banco.sacar(cliente,1, 1000);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    banco.mostrarExtrato(cliente, 1);
    Assertions.assertTrue(output.toString().contains("4000"));
  }

}
