import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        Radix Sort LSD MSD;
        Bucket Sort;
        Tim Sort;
        Heap Sort;
        */

        RadixSort radixSort = new RadixSort(); // A fazer
        BucketSort bucketSort = new BucketSort();
        TimSort timSort = new TimSort();
        HeapSort heapSort = new HeapSort(); // A fazer

        LerArquivo lerArquivo = new LerArquivo();
        String nomeArquivo= "dados500_mil.txt";
        String caminhoArquivoResultado = "/Users/leonardvale/Downloads/resultado.txt";

        int [] arrayNumeros = lerArquivo.lerArrayDoArquivo(nomeArquivo);


        int opcao;
        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "**** Escolha o Algoritmo De Ordenação ****\n\n1 - Radix Sort LSD MSD\n2 - Bucket Sort\n3 - Tim Sort\n4 - Heap Sort\n5 - Sair"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor,selecione uma opção.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        switch (opcao) {
            case 1:
                radixSort.sort(arrayNumeros); // A fazer
                JOptionPane.showMessageDialog(null, "**** Radix Sort ****\n\nTempo de execução: " + RadixSort.formatDuration(RadixSort.duration) +
                        "\nComparações: " + radixSort.getComparisonCount() + "\nQuantidade de trocas: " + radixSort.getMovementCount(), "Radix Sort", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                bucketSort.sort(arrayNumeros);
                JOptionPane.showMessageDialog(null, "**** Bucket Sort ****\n\nTempo de execução: " + BucketSort.formatDuration(BucketSort.duration) +
                        "\nComparações: " + bucketSort.getComparisonCount() + "\nQuantidade de trocas: " + bucketSort.getMovementCount(), "Bucket Sort", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                timSort.sort(arrayNumeros);
                JOptionPane.showMessageDialog(null, "**** Tim Sort ****\n\nTempo de execução: " + TimSort.formatDuration(TimSort.duration) +
                        "\nComparações: " + timSort.getComparisonCount() + "\nQuantidade de trocas: " + timSort.getMovementCount(), "Tim Sort", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                heapSort.sort(arrayNumeros); // A fazer
                JOptionPane.showMessageDialog(null, "**** Heap Sort ****\n\nTempo de execução: " + HeapSort.formatDuration(HeapSort.duration) +
                        "\nComparações: " + heapSort.getComparisonCount() + "\nQuantidade de trocas: " + heapSort.getMovementCount(), "Heap Sort", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminhoArquivoResultado))) {
            bufferedWriter.write(Arrays.toString(arrayNumeros));
            JOptionPane.showMessageDialog(null, "Arquivo ordenado criado em: " + caminhoArquivoResultado, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
