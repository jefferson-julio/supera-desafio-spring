package br.com.banco.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.model.Transferencia_;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransactionService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public Iterable<Transferencia> search(
        String nomeOperadorTransacao,
        Date dataTransferenciaStart,
        Date dataTransferenciaEnd
    ) {
        List<Specification<Transferencia>> querySpecifications = new ArrayList<>();

        if (nomeOperadorTransacao != null) {
            Specification<Transferencia> spec = (root, cq, cb) ->
                cb.equal(root.get(Transferencia_.nomeOperadorTransacao), nomeOperadorTransacao);
            querySpecifications.add(spec);
        }

        if (dataTransferenciaStart != null) {
            Specification<Transferencia> spec = (root, cq, cb) ->
                cb.greaterThanOrEqualTo(root.get(Transferencia_.dataTransferencia), dataTransferenciaStart);
            querySpecifications.add(spec);
        }

        if (dataTransferenciaEnd != null) {
            Specification<Transferencia> spec = (root, cq, cb) ->
                cb.lessThanOrEqualTo(root.get(Transferencia_.dataTransferencia), dataTransferenciaEnd);
            querySpecifications.add(spec);
        }

        var queryParams = querySpecifications
            .stream()
            .collect(Collectors.reducing((s1, s2) -> s1.and(s2)))
            .orElse(null);

        return this.transferenciaRepository.findAll(queryParams);
    }
}
