package com.example.projeto_calculadora_com_testes.service;

import com.example.projeto_calculadora_com_testes.model.Operacao;
import com.example.projeto_calculadora_com_testes.model.TipoOperacao;
import com.example.projeto_calculadora_com_testes.repository.OperacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {
    @Mock
    private OperacaoRepository repository;

    @InjectMocks
    private CalculadoraService calculadoraService;

    @Test
    void deveSomarCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.SOMAR, 10.0, 5.0);
        assertEquals(15.0, resultado);
    }

    @Test
    void deveSubtrairCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.SUBTRAIR, 20.0, 5.0);
        assertEquals(15.0, resultado);
    }

    @Test
    void deveMultiplicarCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.MULTIPLICAR, 5.0, 2.0);
        assertEquals(10.0, resultado);
    }

    @Test
    void deveDividirCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.DIVIDIR, 10.0, 2.0);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveImpedirDivisaoPorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.calcular(TipoOperacao.DIVIDIR, 10.0, 0.0);
        });
    }

    @Test
    void deveCalcularPorcentagemCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.PORCENTAGEM, 120.0, 50.0); // 50% de 120
        assertEquals(60.0, resultado);
    }

    @Test
    void deveCalcularPotenciaCorretamente() {
        double resultado = calculadoraService.calcular(TipoOperacao.POTENCIA, 2.0, 3.0); // 2 elevado a 3
        assertEquals(8.0, resultado);
    }

    @Test
    void deveCalcularRaizQuadradaCorretamente() {
        // O segundo valor (b) é ignorado na raiz quadrada, passamos null
        double resultado = calculadoraService.calcular(TipoOperacao.RAIZ, 25.0, null);
        assertEquals(5.0, resultado);
    }

    @Test
    void deveImpedirRaizDeNumeroNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.calcular(TipoOperacao.RAIZ, -9.0, null);
        });
    }

    @Test
    void deveRegistrarHistoricoDeOperacoes() {
        calculadoraService.calcular(TipoOperacao.SOMAR, 10.0, 5.0);
        calculadoraService.calcular(TipoOperacao.SUBTRAIR, 20.0, 5.0);
        calculadoraService.calcular(TipoOperacao.PORCENTAGEM, 200.0, 10.0);

        ArgumentCaptor<Operacao> captor = ArgumentCaptor.forClass(Operacao.class);

        verify(repository, times(3)).save(captor.capture());

        List<Operacao> operacoesSalvas = captor.getAllValues();

        assertEquals(3, operacoesSalvas.size());
        assertEquals("10.0 + 5.0 = 15.0", operacoesSalvas.get(0).getExpressao());
        assertEquals("20.0 - 5.0 = 15.0", operacoesSalvas.get(1).getExpressao());
        assertEquals("10.0% de 200.0 = 20.0", operacoesSalvas.get(2).getExpressao());
    }
}
