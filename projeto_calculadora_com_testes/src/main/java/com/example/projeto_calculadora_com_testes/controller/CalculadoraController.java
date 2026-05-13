package com.example.projeto_calculadora_com_testes.controller;

import com.example.projeto_calculadora_com_testes.model.TipoOperacao;
import com.example.projeto_calculadora_com_testes.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {
    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calcular")
    public String calcular(
            @RequestParam("valorA") Double valorA,
            @RequestParam(value = "valorB", required = false) Double valorB,
            @RequestParam("operacao") TipoOperacao operacao,
            Model model) {

        try {
            // Pegamos o valor retornado pelo serviço
            double resultado = calculadoraService.calcular(operacao, valorA, valorB);
            // Enviamos esse valor para a tela
            model.addAttribute("resultadoAtual", resultado);

        } catch (IllegalArgumentException e) {
            model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("erro", "Ocorreu um erro ao processar a requisição.");
        }

        return "index";
    }

    @GetMapping("/historico")
    public String historico(Model model) {
        model.addAttribute("historico", calculadoraService.obterHistorico());
        return "historico";
    }
}
