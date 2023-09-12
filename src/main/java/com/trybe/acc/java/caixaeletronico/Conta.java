package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

/**
      Classe Conta.
*/

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private List<Transacao> transacoes = new ArrayList<>();

  /**
    Metodo Construtor.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  /**
      Metodo para Adicionar Transacao.
  */

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
      Metodo para Retornar Saldo.
  */

  public double retornarSaldo() {
    return transacoes.stream().mapToDouble(Transacao::getQuantia).sum();
  }

  /**
      Metodo para Retornar Resumo Conta.
  */

  public void retornarResumoConta() {
    StringBuilder builder = new StringBuilder();
    builder.append(getIdConta()).append(" ").append(retornarSaldo()).append(" ")
        .append(getTipoConta());
    System.out.println(builder);
  }

  /**
      Metodo para Retornar extrato.
  */

  public void retornarExtrato() {
    transacoes.forEach(transacao -> System.out.println(transacao.retornarResumoTransacao()));
  }

  public String getTipoConta() {
    return tipoConta;
  }

  public void setTipoConta(String tipoConta) {
    this.tipoConta = tipoConta;
  }

  public String getIdConta() {
    return idConta;
  }

  public void setIdConta(String idConta) {
    this.idConta = idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  public void setPessoaCliente(PessoaCliente pessoaCliente) {
    this.pessoaCliente = pessoaCliente;
  }

  public List<Transacao> getTransacoes() {
    return transacoes;
  }

  public void setTransacoes(List<Transacao> transacoes) {
    this.transacoes = transacoes;
  }

}
