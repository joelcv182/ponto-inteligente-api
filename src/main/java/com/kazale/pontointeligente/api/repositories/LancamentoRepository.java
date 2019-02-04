package com.kazale.pontointeligente.api.repositories;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.kazale.pontointeligente.api.entities.Lancamento;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
			query = "select lanc from Lancamento lanc where lanc.funcionario.id = :funcionarioId")})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") long funcionarioId);
	
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") long funcionarioId, Pageable pageable);
	
}
