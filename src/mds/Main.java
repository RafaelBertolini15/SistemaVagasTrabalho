package mds;

import java.util.Scanner;

import mds.objetos.Carro;
import mds.objetos.Garagem;
import mds.objetos.Pessoa;
import mds.objetos.Vaga;

import java.util.ArrayList;
import java.util.List;

public class Main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		//parte para criar as vagas
		System.out.println("Sistema da garagem iniciado.");
		System.out.println("Quantas vagas o estacionamento que voce ira registrar os veiculos possue?");
		int capacidade = scan.nextInt();
		Garagem garagem = new Garagem(capacidade);
		garagem.criacaoVagas();
		scan.nextLine();
		
		//parte do menu deixando seu funcionamento em um looping usando while
		boolean menufun = true;
		while(menufun) {
			System.out.println(" ");
			System.out.println("Selecione uma das opcoes do MENU para prosseguir");
			System.out.println(" ");
			System.out.println("1 - para estacionar um carro");
			System.out.println("2 - para remover um carro do estacionamento");
			System.out.println("3 - para conferer a lista de carros estacionados");
			System.out.println("0 - para encerrar o programa");
			int escolha = scan.nextInt();
			
			switch(escolha) {
			case 1:
				estacionandoVeiculo(garagem);
				break;
				
			case 2:
				removerVeiculo(garagem);
				break;
				
			case 3: 
				System.out.println(garagem);
				break;
			case 0:
				System.out.println("Sistema encerrado!");
				menufun=false;
				
				default:
	
			}
		}
}

	static void estacionandoVeiculo(Garagem garagem) {
		
		boolean vagaok;
		
		//parte que mostro quais vagas existem no estacionamento, isso serve so de esqueleto para que a pessoa possa selecionar qual vaga vai poder 
		//estacionar depois, entao aqui e so para dizer que tem x vagas, que e o mesmo numero que a pessoa determinou antes
		System.out.println("As vagas que existem no seu estacionamento sao as seguintes: ");
		for(Vaga vaga : garagem.getNumeroDeVagas()) {
		System.out.println("Vaga "+vaga.getNumero());
		}
		
		//nessa parte na classe garagem mostra quais das vagas printadas a cima esta ocupada
		garagem.vagasOcupadas();
		
		//aqui deixo o usuario escolher qual vaga deseja, com base nas vagas que printei e nas ocupadas
		System.out.println("Diga o numero da vaga que deseja estacionar:");
		int numero = scan.nextInt();
		vagaok=garagem.conferindoVaga(numero);
		if(vagaok) {
			return;
		}
		//esse scan serve para limpar o buffer do scan, os metodos next e nextint nao usam /n, entao se for usar outro scan sem o next line da erro
		scan.nextLine();
	
		System.out.println("Diga o nome do proprietario do carro:");
		String nome = scan.nextLine();
		
		System.out.println("Diga o CPF do proprietario do carro:");
		String cpf = scan.nextLine();
	
		System.out.println("Qual o modelo do carro?");
		String modelo = scan.nextLine();
		
		System.out.println("Qual a placa do carro?");
		String placa = scan.nextLine();
		
		//aqui cria uma nova pessoa, um novo carro e chama o registro de estacionamento da classe garagem
		Pessoa pessoa = new Pessoa (nome, cpf);
		Carro carro = new Carro (placa, modelo);
		garagem.registroEstacionamento(numero, pessoa, carro);
	}

	static void removerVeiculo(Garagem garagem) {
		
		System.out.println("Essa é a lista atual de carros estacionados: ");
		/*criando um looping seguindo a lista d enumero de vagas da classe garagem, para depois printas todas as vagas usando o tostring da classe
		 *  vaga, isso faz que o usuario possa escolhar qual carro remover pelo numero da vaga, facilitando fazer o restante do codigo*/
		 
		for ( Vaga vaga : garagem.getNumeroDeVagas()) {
			System.out.println(vaga);
		}
		
		System.out.println("Qual carro deseja remover? Informe pelo numero da vaga que o carro ocupa.");
		int escolhaRemocao = scan.nextInt();
		scan.nextLine();
		garagem.removendoCarro(escolhaRemocao);
	}
	
}
