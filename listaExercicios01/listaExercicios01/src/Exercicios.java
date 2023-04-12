import javax.swing.*;
import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Exercicios {

    public static void ex1() {
        /* O índice de massa corpórea (IMC) de um indivíduo é obtido dividindo-se o seu peso (em Kg) pelo quadrado daaltura (em metros). Assim, por exemplo, uma pessoa de 1,67m e pesando 55kg tem IMC igual a 19,73. Escreva umprograma que solicite ao usuário o seu peso em kg e sua altura em metros e, a partir deles, calcule o índice demassa corpórea e apresente o resultado de acordo com a situação abaixo.
        IMC Situação< 18,5 Magro18,5 – 24,9 Normal25,0 – 29,9 Sobrepeso30,0 – 34,9 Obeso35,0 – 39,9 Obesidade mórbida */

        Scanner input = new Scanner(System.in);
        System.out.println("Qual seu peso, em kg?");
        double peso = input.nextDouble();
        input.nextLine();
        System.out.println("Qual sua altura, em metros?");
        double altura = input.nextDouble();
        input.nextLine();
        double imc = peso / (Math.pow(altura, 2));

        if(imc < 18.5) {
            System.out.println("Você tem o IMC de uma pessoa magra.");
        }else if(imc < 24.9) {
            System.out.println("Você tem o IMC de uma pessoa normal.");
        }else if(imc < 29.9) {
            System.out.println("Você tem o IMC de uma pessoa sobrepeso.");
        }else if(imc < 34.9) {
            System.out.println("Você tem o IMC de uma pessoa obesa.");
        }else {
            System.out.println("Você tem o IMC de uma pessoa com obesidade mórbida.");
        }
    }

    public static void ex2() {
        /* Faça um programa que peça ao usuário para cadastrar uma senha. Na sequência, deve pedir ao usuário quedigite dois números inteiros e calcular a divisão do primeiro pelo segundo. O programa deve solicitar ao usuárioa senha e, caso esteja correta, mostrar o resultado da divisão. Caso a senha esteja incorreta, mostrar umamensagem de erro e encerrar o aplicativo (sem mostrar o resultado da divisão). OBS: Para encerrar seu aplicativo,utilize o método System.exit(0). */

        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma senha:");
        String senha = input.nextLine();
        System.out.println("Digite dois números inteiros:");
        int num1 = input.nextInt();
        input.nextLine();
        int num2 = input.nextInt();
        input.nextLine();
        System.out.println("Digite novamente sua senha:");
        String confirmacao = input.nextLine();
        if(senha.equals(confirmacao)) {
            System.out.println("O resultado da divisão é: " + (num1/num2));
        } else {
            System.out.println("Senha incorreta, o programa será finalizado.");
            System.exit(0);
        }
    }

    public static void ex3() {
        /* Utilizando o método compareTo() encontre o menor nome (mais próximo da letra A) num grupo de 5 nomes. */

        Scanner input = new Scanner(System.in);
        System.out.println("Digite 5 nomes:");
        String nome1 = input.nextLine();
        String nome2 = input.nextLine();
        String nome3 = input.nextLine();
        String nome4 = input.nextLine();
        String nome5 = input.nextLine();
        String[] listaDeNomes = {nome1, nome2, nome3, nome4, nome5};
        String aux = listaDeNomes[0];

        for(int i = 1; i < 4; i++) {
            if(aux.compareTo(listaDeNomes[i]) > 0) {
                aux = listaDeNomes[i];
            }
        }

        System.out.println("O menor nome é " + aux + ".");
    }

    public static void ex4() {
        /* Faça um programa para verificar a validade de uma senha fornecida pelo usuário. Se o usuário digitar a senha‘123456’, escrever a mensagem ‘Acesso liberado’. Caso contrário, escrever ‘Acesso negado’; */

        System.out.println("Informe a senha:");
        Scanner input = new Scanner(System.in);
        String senha = input.nextLine();

        if(senha.equals("123456")) {
            System.out.println("Acesso liberado.");
        } else {
            System.out.println("Acesso negado.");
        }
    }

    public static void ex5() {
        /* Faça um programa para ler o número de gols marcados pelo Nacional de Patos e o número de gols marcadospelo Treze. Escrever o nome do time vencedor. Caso não haja vencedor, escrever EMPATE. */

        Scanner input = new Scanner(System.in);
        System.out.println("Informe o número de gols marcados pelo Nacional de Patos:");
        int golPatos = input.nextInt();
        input.nextLine();
        System.out.println("Informe o número de gols marcados pelo Treze:");
        int golTreze = input.nextInt();
        input.nextLine();

        if(golPatos > golTreze) {
            System.out.println("O Nacional de Patos é o time vencedor.");
        }else if(golPatos < golTreze) {
            System.out.println("O Treze é o time vencedor.");
        }else {
            System.out.println("EMPATE.");
        }
    }

    public static void ex6() {
        /* Faça um programa que receba um número e exiba o dia correspondente (1 – domingo, 2 – segunda, 3 – terça,4 – quarta, 5 – quinta, 6 – sexta e 7 – sábado). */

        Scanner input = new Scanner(System.in);
        System.out.println("Qual o número do dia de hoje?");
        int dia = input.nextInt();
        input.nextLine();

        switch (dia) {
            case 1 -> System.out.println("Hoje é domingo.");
            case 2 -> System.out.println("Hoje é segunda.");
            case 3 -> System.out.println("Hoje é terça.");
            case 4 -> System.out.println("Hoje é quarta.");
            case 5 -> System.out.println("Hoje é quinta.");
            case 6 -> System.out.println("Hoje é sexta.");
            case 7 -> System.out.println("Hoje é sábado.");
            default -> System.out.println("O número inserido não corresponde a nenhum dia da semana.");
        }
    }

    public static void ex7() {
        /* Faça um programa que leia três valores inteiros A, B e C e diga se a soma de A + B é menor que C. */
        Scanner input = new Scanner(System.in);
        System.out.println("Digite três números inteiros:");
        int num1 = input.nextInt();
        input.nextLine();
        int num2 = input.nextInt();
        input.nextLine();
        int num3 = input.nextInt();
        input.nextLine();

        if((num1 + num2) < num3) {
            System.out.println("A soma dos dois primeiros números é menor que o terceiro.");
        } else {
            System.out.println("A soma dos dois primeiros números é maior que o terceiro.");
        }
    }

    public static void ex8() {
        /* Faça um programa que sorteie 6 números entre 1 e 60. */

        for(int i = 0; i < 6; i++) {
            double sorteio = (Math.random()*59) + 1;
            System.out.printf("%.0f\n", sorteio);
        }
    }

    public static void ex9() {
        /* Um usuário possui uma internet banda larga com velocidade fixa de 2 Mb (2 Megabits) por segundo. Elaboreuma classe que receba o tamanho do arquivo em bytes e apresente a quantidade de segundos necessária parafazer o download. Considere que 8 bits equivalem a 1 byte.  pesquise sobre a classe JOPtionPane para mostrar a janela de diálogo. */

        Scanner input = new Scanner(System.in);
        System.out.println("Quantos bytes tem o arquivo que você deseja baixar?");
        double tamanho = input.nextDouble();
        double tamanhoCovertido = tamanho * 8;
        double tempoParaBaixar = tamanhoCovertido / 2097152;

        SwingUtilities.invokeLater(() -> {
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Tamanho do arquivo em bytes: " + tamanhoCovertido + "\nSegundos necessários para download: " + String.format("%.2f", tempoParaBaixar) + "s");
        });
    }

    public static void ex10() {
        /* Faça um programa em Java para converter um valor em Reais (R$) para dólares (U$) sendo informados ovalor em reais e a cotação do dia. */
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o valor em reais:");
        double dinheiroReais = input.nextDouble();
        input.nextLine();
        System.out.println("Informe a cotação do dólar:");
        double cotacaoDolar = input.nextDouble();
        input.nextLine();
        double dinheiroConvertido = dinheiroReais / cotacaoDolar;
        System.out.println("R$" + String.format("%.2f", dinheiroReais) + " equivale a U$" + String.format("%.2f", dinheiroConvertido) + " na cotação de hoje.");
    }

}
