
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int fibonacciRecursiva(int valor) {
        if (valor == 0) {
            return 0;
        } else if (valor == 1) {
            return 1;
        }
        return fibonacciRecursiva(valor - 1) + fibonacciRecursiva(valor - 2);
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

    public static List<Integer> primosLinear(int valor) {
        List<Integer> arrayPrimos = new ArrayList<>();

        for (int a = 2; a <= valor; a++) {
            boolean Primo = true;

            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    Primo = false;
                    break;
                }
            }

            if (Primo) {
                arrayPrimos.add(a);
            }
        }

        return arrayPrimos;
    }

    public static List<Integer> validarPrimo(int valor, int i, List<Integer> primos) {

        if (valor < 2) {
            return primos;
        }

        if (valor == i) {
            primos.add(valor);
            return primos;
        }

        if (valor % i == 0) {
            return primos;
        }

        if (i * i > valor) {
            primos.add(valor);
            return primos;
        }

        return validarPrimo(valor, i + 1, primos);
    }

    public static List<Integer> primosRecursiva(int numero, int i, List<Integer> primos) {
        if (i > numero) {
            return primos;
        }
        primos = validarPrimo(i, 2, primos);
        return primosRecursiva(numero, i + 1, primos);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numero;

        while (true) {
            // Pergunta o tipo de cálculo desejado
            System.out.println("Escolha a operação:");
            System.out.println("1 - Fibonacci");
            System.out.println("2 - Números Primos");
            System.out.println("Digite 0 para sair.");

            int escolha = scanner.nextInt();

            if (escolha == 0) {
                break;
            }

            switch (escolha) {
                case 1:

                    System.out.println("Digite um número para calcular o Fibonacci:");
                    numero = scanner.nextInt();

                    if (numero < 0) {
                        System.out.println("Insira um número não negativo.");
                    } else {
                        int resultadoRecursivo = fibonacciRecursiva(numero);
                        int resultadoLinear = fibonacciLinear(numero);
                        System.out.println(
                                "Para fib(" + numero + ") utilizando uma função linear temos o retorno do valor "
                                        + resultadoLinear + ", utilizando uma função recursiva temos "
                                        + resultadoRecursivo+".");
                    }
                    break;

                case 2:

                    System.out.println("Digite um número para obter todos os primos até esse número:");
                    numero = scanner.nextInt();

                    if (numero < 2) {
                        System.out.println("Insira um número maior que 1.");
                    } else {
                        List<Integer> primos = primosLinear(numero);
                        List<Integer> primos2 = primosRecursiva(numero, 2, new ArrayList<>());
                        System.out.println(
                                "O conjunto de números primos para p(" + numero + ") utilizando uma função linear é "
                                        + primos + ", utilizando uma função recursiva temos " + primos2 +".");
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}