package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaCliente {
  private String nome;
  private String cpf;
  private String senha;
  private List<Conta> contas = new ArrayList<>();

  public PessoaCliente(String nome, String cpf, String senha) {
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
    StringBuilder builder = new StringBuilder();
    builder.append("Nova pessoa cliente ").append(nome).append(" com cpf ").append(cpf).append(" criada!");
    System.out.println(builder.toString());
  }

  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  public int retornarNumeroDeContas() {
    return contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    return conta.retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    return conta.getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    conta.retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    Conta conta = contas.get(indice);
    conta.adicionarTransacao(quantia,descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha.equals(senha);
  }

  public void retornarResumoContas() {
    contas.forEach(Conta::retornarResumoConta);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public List<Conta> getContas() {
    return contas;
  }

  public void setContas(List<Conta> contas) {
    this.contas = contas;
  }

  public int retornaNumeroDeContas() {
    return contas.size();
  }
}
