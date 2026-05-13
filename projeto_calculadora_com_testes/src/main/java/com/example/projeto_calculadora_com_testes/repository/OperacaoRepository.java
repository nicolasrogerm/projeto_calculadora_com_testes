package com.example.projeto_calculadora_com_testes.repository;

import com.example.projeto_calculadora_com_testes.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
