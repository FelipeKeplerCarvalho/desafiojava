
import java.util.Scanner;

public class Main {

    public static int fibonacciRecursiva(int nthNumber) {
        if (nthNumber == 0) {
            return 0;
        } else if (nthNumber == 1) {
            return 1;
        }
        return fibonacciRecursiva(nthNumber - 1) + fibonacciRecursiva(nthNumber - 2);
    }

    public static int fibonacciLinear(int valor) {

        if (valor < 2 && valor >= 0) {
            return valor;
        }

        int n1 = 0;
        int n2 = 1;
        int n3 = 0;

        for (int i = 2; i <= valor; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

        return n3;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numero;

        while (true) {
            System.out.println(
                    "Escreva um número, ele será usado para resolver a função de Fibonacci de forma recursiva e linear");
            numero = scanner.nextInt();

            if (numero < 0) {
                System.out.println("Insira um número não negativo.");
            } else {
                break;
            }
        }

        if (numero < 0) {
            System.out.println("Número inválido. Por favor, insira um número não negativo.");
        } else {
            int resultadoRecursivo = fibonacciRecursiva(numero);
            int resultadoLinear = fibonacciLinear(numero);
            System.out.println("Resultado de fib(" + numero + ") para a função recursiva:" + resultadoRecursivo + " e Resultado da função linear:" + resultadoLinear );
        }

        scanner.close();
    }
}