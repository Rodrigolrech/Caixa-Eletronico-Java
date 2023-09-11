package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {


  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste1 = new PessoaCliente("Teste1", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste1, banco);

    Assertions.assertEquals(conta.getTipoConta(), tipoConta);
    Assertions.assertEquals(conta.getPessoaCliente(), pessoaClienteTeste1);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste2 = new PessoaCliente("Teste2", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste2, banco);

    conta.adicionarTransacao(500, "Deposito");
    conta.adicionarTransacao(-100, "Saque");

    assertEquals(conta.retornarSaldo(), 400);
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste3 = new PessoaCliente("Teste3", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste3, banco);
    conta.adicionarTransacao(500, "Deposito");

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    conta.retornarResumoConta();
    Assertions.assertTrue(output.toString().contains("500"));
    Assertions.assertTrue(output.toString().contains("Poupança"));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste4 = new PessoaCliente("Teste4", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste4, banco);
    conta.adicionarTransacao(500, "Deposito");
    conta.adicionarTransacao(-100, "Saque");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    conta.retornarExtrato();
    Assertions.assertTrue(output.toString().contains("500"));
    Assertions.assertTrue(output.toString().contains("Deposito"));
    Assertions.assertTrue(output.toString().contains("-100"));
    Assertions.assertTrue(output.toString().contains("Saque"));
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste4 = new PessoaCliente("Teste4", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste4, banco);

    Assertions.assertTrue(conta.getIdConta().length() == 10);
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaClienteTeste4 = new PessoaCliente("Teste4", "12345678911", "1234");
    String tipoConta = "Poupança";
    Conta conta = new Conta(tipoConta, pessoaClienteTeste4, banco);

    Assertions.assertEquals(conta.getPessoaCliente(), pessoaClienteTeste4);
  }

}
