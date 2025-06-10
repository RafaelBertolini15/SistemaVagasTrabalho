package mds.objetos;

public class Carro {
	
	private String placa;
	private String modelo;
	private boolean estacionado;

	public Carro(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.estacionado = false;
	}
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isEstacionado() {
		return estacionado;
	}
	public void setEstacionado(boolean estacionado) {
		this.estacionado = estacionado;
	}
	@Override
	public String toString() {
		return " placa = " + placa + ", modelo = " + modelo + ".";
	}
	
	
	

}
