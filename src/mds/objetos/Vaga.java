package mds.objetos;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
	
	private int numero;
	private Carro carro;
	private Pessoa proprietario;
	
	public Vaga(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Pessoa getProprietario() {
		return proprietario;
	}
	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		// (carro !=null) ? Verifica se o carro existe antes de acessar seus dados, para evitar NullPointerException, que é um erro de quando voce tenta criar algo vazio.
		// essa primeira parte seria para verificar entao se o que eu estou chamando na esta vazio, e se estiver vazio ele vai printar no console que esta vazio
		String infoCarro = (carro != null) ? carro.getModelo() +  " " + carro.getPlaca():  " Nenhum carro.";
		String infoProprietario = (proprietario != null) ? proprietario.getNome()+ " " + proprietario.getCpf() : " Sem proprietario";
		
		//aqui estou fazendo o que vai retornar para o main quando eu chamar
		return "Vaga " + numero + " esta ocupada pelo carro " + infoCarro + " do proprietario " + infoProprietario;
	}
	
	
}
