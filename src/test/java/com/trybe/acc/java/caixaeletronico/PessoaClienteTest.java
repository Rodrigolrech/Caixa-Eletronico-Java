package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {


  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Assertions.assertTrue(output.toString().contains(nome));
    Assertions.assertTrue(output.toString().contains(cpf));
    Assertions.assertEquals(pessoaCliente.getNome(), nome);
    Assertions.assertEquals(pessoaCliente.getCpf(), cpf);
    Assertions.assertEquals(pessoaCliente.getSenha(), senha);
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Conta conta2 = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);

    Assertions.assertEquals(pessoaCliente.getContas().size(), 2);
    Assertions.assertEquals(pessoaCliente.getContas().get(0), conta);
    Assertions.assertEquals(pessoaCliente.getContas().get(1), conta2);
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);


    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 0.0);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,200,"teste");
    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 200.0);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,-100,"teste");
    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 100.0);
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);

    Assertions.assertEquals(pessoaCliente.retornarIdContaEspecifica(0).length(), 10);

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,500, "Deposito");
    pessoaCliente.adicionarTransacaoContaEspecifica(0,-100, "Saque");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    pessoaCliente.retornarExtratoContaEspecifica(0);
    Assertions.assertTrue(output.toString().contains("500"));
    Assertions.assertTrue(output.toString().contains("Deposito"));
    Assertions.assertTrue(output.toString().contains("-100"));
    Assertions.assertTrue(output.toString().contains("Saque"));

  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 0);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,500,"deposito");
    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 500);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,-200,"saque");
    Assertions.assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 300);
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);

    Assertions.assertTrue(pessoaCliente.validarSenha(senha));
    Assertions.assertFalse(pessoaCliente.validarSenha("123"));

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    Banco banco = new Banco();
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.adicionarTransacaoContaEspecifica(0,500, "Deposito");
    Conta conta2 = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta2);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(output);
    System.setOut(ps);
    pessoaCliente.retornarResumoContas();
    Assertions.assertTrue(output.toString().contains("500"));
    Assertions.assertTrue(output.toString().contains("Poupança"));
    Assertions.assertTrue(output.toString().contains("0"));
    Assertions.assertTrue(output.toString().contains("Corrente"));


  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    String nome = "Teste";
    String cpf = "123456789";
    String senha = "1234";
    PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);

    Assertions.assertEquals(pessoaCliente.getCpf(), cpf);

  }

}
