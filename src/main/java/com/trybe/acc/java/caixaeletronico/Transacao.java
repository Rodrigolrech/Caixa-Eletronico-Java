package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 Classe Transacao.
 */
public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  /**
   Metodo Construtor.
   */

  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }

  public double getQuantia() {
    return quantia;
  }

  /**
   Metodo Construtor.
   */
  public String retornarResumoTransacao() {
    StringBuilder builder = new StringBuilder();
    return builder.append(instante).append(" R$")
        .append(quantia).append(" ").append(descricao).toString();
  }

  /**
   Metodo Retornar Instante da Transação.
   */
  public String retornarInstante() {
    LocalDateTime instante = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return instante.format(formatter);
  }

  public void setQuantia(double quantia) {
    this.quantia = quantia;
  }

  public String getInstante() {
    return instante;
  }

  public void setInstante(String instante) {
    this.instante = instante;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }
}

