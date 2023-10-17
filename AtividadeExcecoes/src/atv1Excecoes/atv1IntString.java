package atv1Excecoes;

import java.util.Scanner;

public class atv1IntString {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		String numero;
		
		try {
			System.out.println("Digite uma sequência de números para converter String em Int: ");
			numero = ler.nextLine();
			int n = Integer.parseInt(numero);
			System.out.println("Conversão: " + n);
		}catch(NumberFormatException e) {
			System.out.println("A String não pode ser convertida!");
		}
		ler.close();
	}
}
