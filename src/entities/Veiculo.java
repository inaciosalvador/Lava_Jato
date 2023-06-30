package entities;

import java.util.Scanner;

public class Veiculo {

	Scanner teclado = new Scanner(System.in);

	private Integer id_veiculo;
	private int proprietario;
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

	public int getProprietario() {
		return proprietario;
	}

	public void setProprietario(int i) {
		this.proprietario = i;
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
		return "Veiculo [id_veiculo=" + id_veiculo + ", proprietario=" + proprietario + ", placa=" + placa
				+ ", fabricante=" + fabricante + ", modelo=" + modelo + ", tipo_veiculo=" + tipo_veiculo + "]";
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

	public Veiculo update(Veiculo veiculo) { // tem que receber um veiculo

		int escolha;
		int resposta = 1;

		while (resposta == 1) {
			System.out.println("Quais dados deseja alterar? ");
			System.out.println("1 - placa");
			System.out.println("2 - fabricante");
			System.out.println("3 - modelo");
			System.out.println("4 - tipo de veiculo");
			System.out.println(" ");
			System.out.println("Escolha uma opção");

			escolha = teclado.nextInt();
			teclado.nextLine();

			switch (escolha) {

			case 1:
				System.out.println("Informe a nova Placa: ");
				String placa = teclado.nextLine();
				veiculo.setPlaca(placa);
				break;
			case 2:
				System.out.println("Informe o novo fabricante: ");
				String fabricante = teclado.next();
				veiculo.setFabricante(fabricante);
				break;
			case 3:
				System.out.println("Informe o novo modelo: ");
				String modelo = teclado.next();
				veiculo.setModelo(modelo);
				break;
			case 4:
				System.out.println("Informe o tipo do veiculo: ");
				String tipo = teclado.next();
				veiculo.setTipo_veiculo(tipo);
				break;
			default:
				System.out.println("Escolha uma opção valida");
			}

			System.out.println("Deseja alterar mais algum dado? ");
			System.out.println("1 - sim ");
			System.out.println("2 - Não ");
			resposta = teclado.nextInt();
			teclado.nextLine();
		}

		return veiculo;

	}

}
