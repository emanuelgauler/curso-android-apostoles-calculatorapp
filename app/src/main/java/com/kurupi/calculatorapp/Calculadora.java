package com.kurupi.calculatorapp;

class Calculadora {
    public double sumar(double primer_operando, double segundo_operando) {
        return primer_operando + segundo_operando;
    }

    public double restar(double primer_operando, double segundo_operando) {
        return primer_operando - segundo_operando;
    }

    public double multiplicar(double primer_operando, double segundo_operando) {
        return primer_operando * segundo_operando;
    }

    public double dividir(double primer_operando, double segundo_operando) {
        if (segundo_operando == 0) {
            throw new ErrorDivisionPorCero();
        }
        return primer_operando / segundo_operando;
    }

    public class ErrorDivisionPorCero extends IllegalArgumentException {
        public ErrorDivisionPorCero() {
            super("No se puede dividir por 0");
        }
    }
}
