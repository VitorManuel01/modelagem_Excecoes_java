package atv2Excecoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<Pessoa> usuarios = new ArrayList<Pessoa>();
		Scanner ler = new Scanner(System.in);
		do {
			System.out.println("Digite um nome: ");
			String nome = ler.nextLine();
			if(nome.equalsIgnoreCase("fim")) {
				break;
			}
			System.out.println("Digite a idade: ");
			int idade = ler.nextInt();
			ler.nextLine();
			
			usuarios.add(new Pessoa(nome, idade));
			
		}while(true);

		System.out.println("Deseja realizar uma consulta? \n1-Sim \n2-Não");
		int opcao = ler.nextInt();
		ler.nextLine();
		if(opcao == 1) {
			System.out.println("Digite um nome para consultar: ");
			String nomeConsultado = ler.nextLine();
			Pessoa filtro = new Pessoa(nomeConsultado, 0);
			int posicao = usuarios.indexOf(filtro);
			
			if(posicao == -1) {
				ler.close();
				throw new Exception("ERRO! NOME NÃO ENCONTRADO!");
			}else {
				ler.close();
				System.out.println("Idade: " + usuarios.get(posicao).getIdade());
			}
		}else {
			ler.close();
			System.out.println("FIM DO PROGRAMA!");
		}
	}
}
