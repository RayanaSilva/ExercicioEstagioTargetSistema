package com.targetsistemas.segundapergunta;
import java.util.Scanner;

/* 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será
 * a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um
 * programa na linguagem que desejar onde, informado um número, ele calcule a sequência de
 * Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
 * IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência
 * ou pode ser previamente definido no código;
*/

public class SegundaPergunta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        scanner.close();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean isFibonacci(int n) {
        int a = 0, b = 1;
        while (a < n) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a == n;
    }
}
