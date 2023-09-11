package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(200, "Saque");
    Assertions.assertEquals(transacao.getQuantia(), 200);
    Assertions.assertEquals(transacao.getDescricao(), "Saque");
    Assertions.assertEquals(transacao.getInstante().length(), 19);

  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(200, "Saque");
    Assertions.assertEquals(transacao.getQuantia(), 200);
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(200, "Saque");
    Assertions.assertTrue(transacao.retornarResumoTransacao().contains("200"));
    Assertions.assertTrue(transacao.retornarResumoTransacao().contains("Saque"));
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(200, "Saque");
    Assertions.assertEquals(transacao.getInstante().length(), 19);
    Assertions.assertTrue(transacao.getInstante().contains(String.valueOf(LocalDateTime.now().getDayOfMonth())));
    Assertions.assertTrue(transacao.getInstante().contains(String.valueOf(LocalDateTime.now().getHour())));
  }

}
