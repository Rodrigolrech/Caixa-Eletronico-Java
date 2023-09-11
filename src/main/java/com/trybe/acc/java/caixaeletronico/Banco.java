package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/*
  Classe Banco
*/

public class Banco {

  /*
    Atributos da Classe Banco
 */
  private List<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private List<Conta> contas = new ArrayList<Conta>();

  /*
      Metodo para Gerar Numero Aleatorio para uma Nova Conta
  */

  public String gerarNumeroNovaConta() {
    Random random = new Random();
    long conta = random.nextLong();
    if (conta < 0) {
      conta = conta * -1;
    }
    return Long.toString(conta).substring(9);
  }
  /*
      Metodo para Adicionar Pessoa Cliente
  */

  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    Optional<PessoaCliente> cpfUtilizado = pessoasClientes
        .stream().filter(customer -> customer.getCpf().equals(cpf)).findAny();
    if (cpfUtilizado.isEmpty()) {
      PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
      pessoasClientes.add(pessoaCliente);
      return pessoaCliente;
    }
    return null;
  }

  /*
      Metodo para Adicionar Conta
  */

  public void adicionarConta(Conta novaConta) {
    contas.add(novaConta);
  }

  /*
      Metodo para login de Pessoa Cliente
  */

  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    Optional<PessoaCliente> login = pessoasClientes.stream()
        .filter(a -> a.getCpf().equals(cpf) && a.getSenha().equals(senha)).findFirst();
    return login.orElse(null);
  }

  /*
      Metodo para transaferir fundos
  */

  public void transferirFundos(
      PessoaCliente pessoaCliente, int daConta, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia * -1, "Transferencia enviada");
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Transferencia recebida");
  }

  /*
      Metodo para Sacar
  */

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia * -1, "Saque realizado");
  }

  /*
      Metodo para Depositar
  */

  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Deposito realizado");
  }

  /*
      Metodo para Mostrar Extrato
  */

  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }

  /*
      Metodo para Mostrar Pessoas Clientes
  */

  public List<PessoaCliente> getPessoasClientes() {
    return pessoasClientes;
  }

  public void setPessoasClientes(
      List<PessoaCliente> pessoasClientes) {
    this.pessoasClientes = pessoasClientes;
  }

  public List<Conta> getContas() {
    return contas;
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
  }
}
