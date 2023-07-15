package br.com.banco.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.model.TransferenciaSaldo;
import br.com.banco.model.Transferencia_;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransactionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    private Specification<Transferencia> generateSearchSpecification(
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

        return queryParams;
    }

    public Iterable<Transferencia> search(
        String nomeOperadorTransacao,
        Date dataTransferenciaStart,
        Date dataTransferenciaEnd,
        Pageable pageable
    ) {
        return this.transferenciaRepository.findAll(this.generateSearchSpecification(
            nomeOperadorTransacao,
            dataTransferenciaStart,
            dataTransferenciaEnd
        ), pageable);
    }

    public TransferenciaSaldo calculateBalance(
        String nomeOperadorTransacao,
        Date dataTransferenciaStart,
        Date dataTransferenciaEnd
    ) {
        var whereParams = this.generateSearchSpecification(
            nomeOperadorTransacao,
            dataTransferenciaStart,
            dataTransferenciaEnd
        );

        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(Double.class);
        var root = cq.from(Transferencia.class);
        cq.select(cb.sum(root.get(Transferencia_.valor)));

        var totalBalance = entityManager.createQuery(cq).getSingleResult();
        if (totalBalance == null) {
            totalBalance = 0.0;
        }

        cq.where(whereParams.toPredicate(root, cq, cb));

        var periodBalance = entityManager.createQuery(cq).getSingleResult();
        if (periodBalance == null) {
            periodBalance = 0.0;
        }

        return new TransferenciaSaldo(totalBalance, periodBalance);
    }
}
