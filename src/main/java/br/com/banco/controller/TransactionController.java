package br.com.banco.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransactionService;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(path = "/search")
    public Iterable<Transferencia> search(
        @RequestParam(required = false) String nomeOperadorTransacao,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataTransferenciaStart,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataTransferenciaEnd
    ) {
        return this.transactionService.search(
            nomeOperadorTransacao,
            dataTransferenciaStart,
            dataTransferenciaEnd
        );
    }
}
