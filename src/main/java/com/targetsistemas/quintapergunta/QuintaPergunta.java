package com.targetsistemas.quintapergunta;
import java.util.Scanner;

/* 5) Escreva um programa que inverta os caracteres de um string.
 *
 * IMPORTANTE:
 * a) Essa string pode ser informada através de qualquer entrada de sua preferência ou
 * pode ser previamente definida no código;
 * b) Evite usar funções prontas, como, por exemplo, reverse;
*/

public class QuintaPergunta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String entrada = scanner.nextLine();
        scanner.close();

        String stringInvertida = inverterString(entrada);
        System.out.println("String invertida: " + stringInvertida);
    }

    public static String inverterString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
