package com.targetsistemas.terceirapergunta;
import java.util.Arrays;

public class FaturamentoCalculadora {
    // Método para calcular o menor valor de faturamento
    public double calcularMenorFaturamento(double[] faturamento) {
        return Arrays.stream(faturamento)
                .filter(f -> f > 0) // Ignorar dias sem faturamento
                .min()
                .orElse(0);
    }

    // Método para calcular o maior valor de faturamento
    public double calcularMaiorFaturamento(double[] faturamento) {
        return Arrays.stream(faturamento)
                .filter(f -> f > 0) // Ignorar dias sem faturamento
                .max()
                .orElse(0);
    }

    // Método para calcular a média mensal
    public double calcularMediaMensal(double[] faturamento) {
        return Arrays.stream(faturamento)
                .filter(f -> f > 0) // Ignorar dias sem faturamento
                .average()
                .orElse(0);
    }

    // Método para contar os dias com faturamento acima da média
    public long contarDiasAcimaDaMedia(double[] faturamento, double mediaMensal) {
        return Arrays.stream(faturamento)
                .filter(f -> f > mediaMensal) // Faturamento acima da média
                .count();
    }
}
