package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private List<Transacao> transacoes = new ArrayList<>();

  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }
  public double retornarSaldo(){
    return transacoes.stream().mapToDouble(Transacao::getQuantia).sum();
  }

  public void retornarResumoConta() {
    StringBuilder builder = new StringBuilder();
    builder.append(getIdConta()).append(" ").append(retornarSaldo()).append(" ").append(getTipoConta());
    System.out.println(builder);
  }

  public void retornarExtrato() {
    transacoes.forEach(Transacao -> System.out.println(Transacao.retornarResumoTransacao()));
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
