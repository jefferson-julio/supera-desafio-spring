package br.com.banco.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
}
