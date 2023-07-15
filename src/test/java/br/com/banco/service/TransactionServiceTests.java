package br.com.banco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@SpringBootTest
public class TransactionServiceTests {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransactionService transactionService;

    @BeforeEach
    void setup() {
        transferenciaRepository.deleteAll();
        contaRepository.deleteAll();

        var c1 = new Conta();
        c1.setNomeResponsavel("beltrano1337");
        contaRepository.save(c1);
        Date dataTransacao1 = new Date(2020, 2, 1);
        Date dataTransacao2 = new Date(2018, 2, 1);

        var t1 = new Transferencia();
        t1.setNomeOperadorTransacao("fulano1");
        t1.setConta(c1);
        t1.setTipo("DEPOSITO");
        t1.setValor(100.0);
        t1.setDataTransferencia(dataTransacao1);
        transferenciaRepository.save(t1);
        var t2 = new Transferencia();
        t2.setNomeOperadorTransacao("siclano1");
        t2.setConta(c1);
        t2.setTipo("DEPOSITO");
        t2.setValor(100.0);
        t2.setDataTransferencia(dataTransacao1);
        transferenciaRepository.save(t2);
        var t3 = new Transferencia();
        t3.setNomeOperadorTransacao("beltrano1337");
        t3.setConta(c1);
        t3.setTipo("DEPOSITO");
        t3.setValor(100.0);
        t3.setDataTransferencia(dataTransacao1);
        transferenciaRepository.save(t3);
        var t4 = new Transferencia();
        t4.setNomeOperadorTransacao("beltrano1337");
        t4.setConta(c1);
        t4.setTipo("DEPOSITO");
        t4.setValor(200.0);
        t4.setDataTransferencia(dataTransacao2);
        transferenciaRepository.save(t4);
        
    }

    @Test
    void testSearch_nomeOperadorTransacao() {
        var searchValue = "beltrano1337";
        var results = this.transactionService.search(searchValue, null, null).iterator();

        while (results.hasNext()) {
            var result = results.next();
            assertEquals(searchValue, result.getNomeOperadorTransacao());
        }
    }

    @Test
    void testSearch_dataTransferenciaStart() {
        var searchValue = new Date(2020, 1, 1);
        var results = this.transactionService.search(null, searchValue, null);

        int count = 0;
        for (var _i : results) {
            count++;
        }

        assertEquals(true, count > 0);
    }

    @Test
    void testSearch_dataTransferenciaEnd() {
        var searchValue = new Date(2022, 1, 1);
        var results = this.transactionService.search(null, null, searchValue);

        int count = 0;
        for (var _i : results) {
            count++;
        }

        assertEquals(true, count > 0);
    }

    @Test
    void testSearch_combinedQuery() {
        var searchStringValue = "beltrano1337";
        var searchDateValue = new Date(2019, 12, 1);
        var results = this.transactionService.search(searchStringValue, null, searchDateValue);

        int count = 0;
        for (var i : results) {
            assertEquals(searchStringValue, i.getNomeOperadorTransacao());
            count++;
        }

        assertEquals(true, count == 1);
    }
}
