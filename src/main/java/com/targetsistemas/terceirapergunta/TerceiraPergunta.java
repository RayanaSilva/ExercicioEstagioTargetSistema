package com.targetsistemas.terceirapergunta;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça
 * um programa, na linguagem que desejar, que calcule e retorne:
 * • O menor valor de faturamento ocorrido em um dia do mês;
 * • O maior valor de faturamento ocorrido em um dia do mês;
 * • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
 *
 * IMPORTANTE:
 * a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
 * b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias
 * devem ser ignorados no cálculo da média;
 */

public class TerceiraPergunta {
    public static void main(String[] args) {
        try {
            // Ler o JSON de um arquivo
            String jsonString = new String(Files.readAllBytes(Paths.get("faturamento.json")));
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

            // Converter o JSONArray em um vetor de double
            double[] faturamentoDiario = new double[faturamentoArray.length()];
            for (int i = 0; i < faturamentoArray.length(); i++) {
                faturamentoDiario[i] = faturamentoArray.getDouble(i);
            }

            // Criar uma instância da classe FaturamentoCalculadora
            FaturamentoCalculadora calculadora = new FaturamentoCalculadora();

            // Calcular menor e maior valor de faturamento
            double menorFaturamento = calculadora.calcularMenorFaturamento(faturamentoDiario);
            double maiorFaturamento = calculadora.calcularMaiorFaturamento(faturamentoDiario);

            // Calcular a média mensal e o número de dias acima da média
            double mediaMensal = calculadora.calcularMediaMensal(faturamentoDiario);
            long diasAcimaDaMedia = calculadora.contarDiasAcimaDaMedia(faturamentoDiario, mediaMensal);

            // Imprimir os resultados
            System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorFaturamento);
            System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
