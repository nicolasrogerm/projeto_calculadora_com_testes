package com.example.projeto_calculadora_com_testes.model;

public enum TipoOperacao {

    SOMAR {
        @Override
        public double calcular(double a, double b) { return a + b; }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return a + " + " + b + " = " + resultado; }
    },
    SUBTRAIR {
        @Override
        public double calcular(double a, double b) { return a - b; }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return a + " - " + b + " = " + resultado; }
    },
    MULTIPLICAR {
        @Override
        public double calcular(double a, double b) { return a * b; }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return a + " * " + b + " = " + resultado; }
    },
    DIVIDIR {
        @Override
        public double calcular(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("Divisão por zero não permitida");
            }
            return a / b;
        }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return a + " / " + b + " = " + resultado; }
    },
    PORCENTAGEM {
        @Override
        public double calcular(double a, double b) { return (a * b) / 100.0; }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return b + "% de " + a + " = " + resultado; }
    },
    POTENCIA {
        @Override
        public double calcular(double a, double b) { return Math.pow(a, b); }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return a + " elevado a " + b + " = " + resultado; }
    },
    RAIZ {
        @Override
        public double calcular(double a, double b) {
            if (a < 0) {
                throw new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo.");
            }
            return Math.sqrt(a);
        }
        @Override
        public String formatarExpressao(double a, double b, double resultado) { return "Raiz quadrada de " + a + " = " + resultado; }
    };

    public abstract double calcular(double a, double b);
    public abstract String formatarExpressao(double a, double b, double resultado);
}
