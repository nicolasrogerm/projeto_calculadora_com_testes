package com.example.projeto_calculadora_com_testes.service;

import com.example.projeto_calculadora_com_testes.model.Operacao;
import com.example.projeto_calculadora_com_testes.model.TipoOperacao;
import com.example.projeto_calculadora_com_testes.repository.OperacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {

    private final OperacaoRepository repository;

    public CalculadoraService(OperacaoRepository repository) {
        this.repository = repository;
    }

    public List<Operacao> obterHistorico() {
        return repository.findAll();
    }

    private double salvarRetornar(String expressao, double resultado) {
        repository.save(new Operacao(expressao));
        return resultado;
    }

    public double calcular(TipoOperacao operacao, Double a, Double b) {
        double valB = (b != null) ? b : 0;

        double resultado = operacao.calcular(a, valB);
        String expressao = operacao.formatarExpressao(a, valB, resultado);

        repository.save(new Operacao(expressao));

        return resultado;
    }
}
