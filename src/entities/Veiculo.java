package entities;

import java.util.Scanner;

public class Veiculo {
	
	Scanner teclado = new Scanner(System.in);
	
	private Integer id_veiculo;
	private Cliente proprietario;
	private String placa;
	private String fabricante;
	private String modelo;
	private String tipo_veiculo;
	
	public Veiculo() {		
	}
	
	public Veiculo(String placa, String fabricante, String modelo, String tipo_veiculo) {
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.tipo_veiculo = tipo_veiculo;
	}

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public Cliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo_veiculo() {
		return tipo_veiculo;
	}

	public void setTipo_veiculo(String tipo_veiculo) {
		this.tipo_veiculo = tipo_veiculo;
	}

	@Override
	public String toString() {
		return "Veiculo [id_veiculo="
				+ id_veiculo
				+ ", proprietario="
				+ proprietario
				+ ", placa="
				+ placa
				+ ", fabricante="
				+ fabricante
				+ ", modelo="
				+ modelo
				+ ", tipo_veiculo="
				+ tipo_veiculo + "]";
	}

	
	public Veiculo createVeiculo() {

		System.out.println("Insira a placa do veiculo");
		placa = teclado.nextLine();
		
		System.out.println("Fabricante: ");
		fabricante = teclado.nextLine();
		
		System.out.println("Modelo: ");
		modelo = teclado.nextLine();
		
		System.out.println("Tipo de veiculo: ");
		tipo_veiculo = teclado.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, fabricante, modelo, tipo_veiculo);
		return veiculo;
	}
		
}
