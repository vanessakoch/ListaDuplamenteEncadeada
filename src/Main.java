import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Scanner t;

	public static void main(String[] args) {
		Lista lista1 = new Lista();

		Random random = new Random();
		random.setSeed(0);
		t = new Scanner(System.in);

		// -------------------------------//--------------------------//------------------------------//

		System.out.println("\t ESCOLHA O ESTILO DA LISTA");
		System.out.println("1 - 10 mil elementos com valores de 0 a mil.");
		System.out.println("2 - 10 mil elementos com valores de 0 a 1 milhão.");
		System.out.println("3 - 100 mil elementos com valores de 0 a mil.");
		System.out.println("4 - 100 mil elementos com valores de 0 a 1 milhão.");

		int opcao = t.nextInt();

		switch (opcao) {

		case 1:
			for (int i = 0; i < 10000; i++) {
				lista1.inserirElementoInicio(new Dado(random.nextInt(1000)));
			}
			break;
		case 2:
			for (int i = 0; i < 10000; i++) {
				lista1.inserirElementoInicio(new Dado(random.nextInt(1000000)));
			}
			break;
		case 3:
			for (int i = 0; i < 100000; i++) {
				lista1.inserirElementoInicio(new Dado(random.nextInt(1000)));
			}
			break;
		case 4:
			for (int i = 0; i < 100000; i++) {
				lista1.inserirElementoInicio(new Dado(random.nextInt(1000000)));
			}
			break;
		default:
			break;
		}

		System.out.println("\t ESCOLHA O MÉTODO DE ORDENAÇÃO");
		System.out.println("1 - Bubble Sort");
		System.out.println("2 - Selection Sort");
		System.out.println("3 - Insertion Sort");

		int ordena = t.nextInt();

		switch (ordena) {

		case 1:
			System.out.println("Aguarde ...");
			long tempoInicial1 = System.currentTimeMillis();
			lista1.bubbleSort();
			lista1.listarElemento();
			System.out.println(
					"\n\t\tO metodo executou em " + (System.currentTimeMillis() - tempoInicial1) + " milissegundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial1) / 1000) + " segundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial1) / 60000) + " minutos!");
			break;

		case 2:
			System.out.println("Aguarde ...");
			long tempoInicial2 = System.currentTimeMillis();
			lista1.selectionSort();
			lista1.listarElemento();
			System.out.println(
					"\n\t\tO metodo executou em " + (System.currentTimeMillis() - tempoInicial2) + " milissegundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial2) / 1000) + " segundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial2) / 60000) + " minutos!");
			break;

		case 3:
			System.out.println("Aguarde ...");
			long tempoInicial3 = System.currentTimeMillis();
			lista1.insertionSort();
			lista1.listarElemento();
			System.out.println(
					"\n\t\tO metodo executou em " + (System.currentTimeMillis() - tempoInicial3) + " milissegundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial3) / 1000) + " segundos!");
			System.out.println(
					"\t\tO metodo executou em " + ((System.currentTimeMillis() - tempoInicial3) / 60000) + " minutos!");
			break;

		default:
			break;
		}
	}
}
