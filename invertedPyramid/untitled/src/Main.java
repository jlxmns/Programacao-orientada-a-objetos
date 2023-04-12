//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.stream.Stream;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Digite uma sequência de números inteiros:");
//        String listaText = input.nextLine();
//        System.out.println("▶──◆─◈─◇─◈─◆──◀");
//
//        /* Primeiro separamos os elementos da array de string usando o regex "\\s+", que inclui todos os espaços em branco
//        * depois transformamos nossos elementos da array de strings em Stream
//        * usando Stream, podemos usar o método de Stream .mapToInt, usando como parâmetro a classe Integer e chamando o método parseInt através de referência usando ::
//        * o método mapToInt vai percorrer nossa Stream e transformar as Strings em int
//        * após isso, transformamos nossa Stream em um array usando o método de Stream .toArray() */
//        int[] list = Stream.of(listaText.split("\\s+")).mapToInt(Integer::parseInt).toArray();
//
//        /* fórmula da soma de elementos da sequência aritmética: Sn = (n/2) [2a + (n - 1)d]
//        * em nosso caso, a = 1 e d = 1, pois a primeira linha tem 1 elemento e a diferença dela para a 2a linha é de 1 elemento
//        * podemos reescrever como: Sn = n/2 * (n+1)
//        * para achar o número de linhas, precisamos achar o valor de N para n/2 * (n+1) >= N, onde N é o número de elementos da array
//        * para resolver essa inequação, podemos multiplicar ambos os lados por 2 e temos: n * (n+1) >= 2N
//        * passando para o lado esquerdo temos: n² + n - 2N >= 0
//        * aplicando a fórmula quadrática para descobrir n: n = (-1 +/- sqrt(1²-4*1*(-2N)))/2*1
//        * simplificando a fórmula temos: n = (-1 +/- sqrt(1+8N))/2
//        * já que queremos um inteiro positivo, temos que n = (-1 + sqrt(1+8N))/2, que deve ser arredondado
//        */
//
//        //Aplicando a equação acima e arredondando:
//        double calculoDasLinhas = (-1 + Math.sqrt(1 + 8 * list.length))/2;
//        int numeroDeLinhas = (int)Math.ceil(calculoDasLinhas);
//
//        //Exibindo nossa pirâmide invertida:
//        for(int i = 0, k = 0; i < numeroDeLinhas; i++) {
//            for(int j = 0; j <= i; j++) {
//                if(k > (list.length - 1))
//                    break;
//                System.out.printf("%s\t", list[k++]);
//            }
//            System.out.print("\n");
//        }
//
//        /* Criando duas arrays: uma será usada para armazenar informações temporárias dentro do for
//        * A outra será utilizada para armazenar os menores números de cada linha */
//        int[] tempArray = null;
//        int[] menorNumero = new int[numeroDeLinhas];
//
//        //Fazendo o loop pela array para copiar os valores de cada linha na array temporária e armazenar os menores números
//        for(int i = 0, j = 0, k = 0; i < numeroDeLinhas; i++, j = k) {
//            if(k >= 1) {
//                    k = k + tempArray.length + 1;
//                    if(k > list.length) {
//                        k = list.length;
//                    }
//            } else {
//                k++;
//            }
//            tempArray = Arrays.copyOfRange(list, j, k);
//
//            int menorNum = tempArray[0];
//            for(int l = 0; l < tempArray.length; l++) {
//                if(menorNum > tempArray[l]) {
//                    menorNum = tempArray[l];
//                }
//            }
//            menorNumero[i] = menorNum;
//        }
//
//        System.out.println("▶──◆─◈─◇─◈─◆──◀");
//
//        //Criando variável para armazenar a soma e loop na array de menores números para somar todos os elementos dela
//        int soma = 0;
//        for(int i = 0; i < menorNumero.length; i++) {
//            soma = soma + menorNumero[i];
//        }
//
//        //Apresentando os dados para o usuário
//        System.out.println("Os menores números são: " + Arrays.toString(menorNumero) +
//                "\nA soma dos menores números de cada linha é: " + soma);
//    }
//}