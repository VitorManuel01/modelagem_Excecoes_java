package atv1Excecoes;

import java.util.Scanner;

import excecoesCustomizadas.ExcecaoCompIdade;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class atv1NomeDataIdade {
	private static String nome;
	private static String dataNasc;
	private static String idade;
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) throws ExcecaoCompIdade {
		cadastro();
	}
	
	static void cadastro() throws ExcecaoCompIdade {
		try {
			System.out.println("Digite seu nome: ");
			nome = ler.nextLine();
			System.out.println("Digite sua data de nascimento (dd/MM/yyyy): ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataNasc = ler.nextLine();
			LocalDate dataNascimento = LocalDate.parse(dataNasc, formatter);			
			
			System.out.println("Digite sua idade: ");
			idade = ler.nextLine();
			int idadeUser = Integer.parseInt(idade);			
			
			System.out.println("Nome do usuário: " + nome);
			System.out.println("\nData de Nascimento: " + dataNascimento.format(formatter));
			System.out.println("\nIdade: " + idadeUser);
			
			int idadeComparativa = compararDataIdade(dataNascimento);
			
			if(idadeUser != idadeComparativa) {
				throw new ExcecaoCompIdade("A idade digitada não bate com a data de nascimento informada!");
			}
		} catch (java.time.format.DateTimeParseException e) {
			System.out.println("Digita a data do jeito certo imbecil!");
		} catch(NumberFormatException e) {
			System.out.println("Para de ser burro, já viu idade ser em letra? -tem por extenso eu sei. MAS NÃO É, CORNO!");
		}
	}
	
	static int compararDataIdade(LocalDate dataNascimento) {
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNascimento, dataAtual);
		return periodo.getYears();
	}
}
