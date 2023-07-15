package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Transferencia;

public interface TransferenciaRepository extends CrudRepository<Transferencia, Integer>, JpaSpecificationExecutor<Transferencia> {
}
