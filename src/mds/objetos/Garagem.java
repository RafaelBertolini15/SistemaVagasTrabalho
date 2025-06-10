package mds.objetos;

import java.util.ArrayList;
import java.util.List;

public class Garagem {
	
	private int capacidadeMaxima;
	private Vaga vaga;
	private  List<Vaga> numeroDeVagas;
	private  List<Integer> vagasOcupadas;

	public Garagem(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
		numeroDeVagas = new ArrayList<>();
		vagasOcupadas = new ArrayList<>();
		
		}
	
	//nessa parte e onde se cria as vagas, guardando todas as vagas criadas dentro de uma lista
	public void criacaoVagas () {
		for(int i=1; i<=capacidadeMaxima; i++) {
			numeroDeVagas.add(new Vaga(i));
		}
	}
	
	public void vagasOcupadas () {
		
		/*Aqui é a parte onde vou printar para o usuario quais vagas estao ocupadas para ele poder selecionar no console uma vaga livre, ela serve
		 * tambem para quando todas vagas estiverem ocupadas, informa o usuario e volta para o menu*/
		System.out.println(" ");
		if(vagasOcupadas.isEmpty()) {
			System.out.println("No momento, nenhuma das vagas do estacionamento esta ocupada");
			System.out.println("");
		}else if (vagasOcupadas.size()+1>capacidadeMaxima){
			System.out.println("Impossivel estacionar no momento, todas as vagas estao ocupadas.");
			System.out.println(" ");
			return;
		}else {
			System.out.println("As vagas ocupadas no momento são: " + vagasOcupadas);
			System.out.println("");
		}
	}
	
	public boolean conferindoVaga(int numero) {
		/*Nesse parte eu faco a verificacao de quando selecionado uma vaga, se essa vaga ja nao esta ocupada, se ela nao e uma vaga invalida, ou se 
		 * estiver tudo certo, mostro para o usuario que a vaga esta ok*/
		if(numero<=0 || numero>capacidadeMaxima) {
			System.out.println("Por favor, selecione uma vaga coerente com as vagas disponiveis");
			return true;
		}else if (vagasOcupadas.contains(numero)) {
			System.out.println("Voce selecionou uma vaga que ja esta ocupada");
			return true;
		}else {
			System.out.println("A vaga esta disponivel!");
			return false;
		}
	}
	
	/*Nessa parte eu pego a placa que for digitada e verifico se ela ja existe, isso faz que o sistema nao permita registrar dois carros com a mesma
	 * placa*/
	public boolean verificaPlaca(String placa) {

		/*aqui eu faço um looping verificando toda a lista de vagas registradas*/ 
		for(Vaga vaga : numeroDeVagas) {
			/*Guardo dentro de um novo carro as informacoes do carro guardado na vaga no numero que o looping e esta passando, e depois disso faco
			 * a verificacao se na vaga que eu peguei, uso carro verifica ! = null para verificar se essa vaga realmente exista e que o sistema 
			 * tente pegar algo que nao existe, depois, pego a placa e uso equalignorecase, que ignora maiusculas e minusculas e confiro para 
			 * ver se e igual, se for igual retorna true, dizendo que o carro esta estacionado */
			Carro carroVerifica = vaga.getCarro();
			if(carroVerifica != null && carroVerifica.getPlaca().equalsIgnoreCase(placa) ) {
			return true;
		}
		}
	return false;
	}

	//parte onde registro o estacionamento
		public void registroEstacionamento(int numero, Pessoa pessoa, Carro carro) {
			
			/*Aqui e a parte complementar a de cima, eu chamo o que fiz la em cima, e faco ser funcional */
			if(verificaPlaca(carro.getPlaca())) {
				System.out.println("A placa "+carro.getPlaca()+" ja contem nos dados de um carro ja estacionado na garagem, o carro nao foi estacionado.");
				return;
			}
			
			/* Aqui eu crio uma nova vaga, e guardo nela qual vaga da lista que desejo guardar, pegando numero - 1 para acessar o indice certo da lista*/
			Vaga vagaSelecionada = numeroDeVagas.get(numero-1);
			
			//aqui seto o carro dentro da nova vaga
			vagaSelecionada.setCarro(carro);
			vagaSelecionada.setProprietario(pessoa);
			System.out.println("O carro informado foi estacionado na vaga "+ numero);
			carro.setEstacionado(true);
			vagasOcupadas.add(numero);
		}
		
		public void removendoCarro(int remove) {
			//aqui crio uma nova vaga e guardando a vaga escolhida que esta dentro da lista de vaga
			Vaga vaga = numeroDeVagas.get(remove-1);
			//nesse if confiro primeiro se a vaga que a pessoa escolheu nao esta vazia, pedindo para o sistema ver se a vaga e diferente de nulo
			if(vaga.getCarro()!= null) {
				//seto os novos valores da vaga, colando nulo e removendo os dados dos carros
				vaga.setCarro(null);
				vaga.setProprietario(null);
				//pego a lista de vagas ocupadas e removo o valor escolhido da lista, o integer value of serve para conseguir remover o valor 
				//caso nao existisse, iria remover o indice, podendo remover o valor errado
				vagasOcupadas.remove(Integer.valueOf(remove));
				System.out.println("O carro da vaga "+ remove + " foi removido com sucesso!");
			}else {
				System.out.println("A vaga "+remove+" que foi a que voce escolher ja esta vazia.");
			}
		}
	
	
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public List<Vaga> getNumeroDeVagas() {
		return numeroDeVagas;
	}

	public  List<Integer> getVagasOcupadas() {
		return vagasOcupadas;
	}

	public void setVagasOcupadas(List<Integer> vagasOcupadas) {
		this.vagasOcupadas = vagasOcupadas;
	}

	@Override
	public String toString() {
		/*criando uma string para chamar direto a lista de vagas no main*/
		String Texto = "- - - LISTA DE CARROS ESTACIONADO AGORA - - - \n";
		
		/*aqui passo o looping para verificar todas as vagas*/
		for(Vaga vaga : numeroDeVagas) {
			/*digo se o valor da vaga nao for nulo, vai printar isso*/
			if(vaga.getCarro()!=null) {
				Texto += " A vaga: " +vaga.getNumero() + " - esta preenchida pelo carro: " + vaga.getCarro().getModelo() + " - de placa: " + vaga.getCarro().getPlaca() + " - do proprietario de nome " + vaga.getProprietario().getNome() + " - com o CPF "+vaga.getProprietario().getCpf()+" . \n";
			}else /*Digo que caso a vaga seja nula vai printar isso*/{
				Texto+=" Nenhum carro esta estacionado na vaga "+ vaga.getNumero()+ ".\n";
		}
		}
		
		return Texto;
	}



	
	
	}




	
	


