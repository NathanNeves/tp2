package projetonumeros;

class veiculo{
	private String modelo;
	private double velocidademinima;
	private double velocidademaxima;
	private String fabricante;
	private String Cor;
	veiculo(String modelo,double velocidademinima,double velocidademaxima,String fabricante,String cor){
		this.modelo = modelo;
		this.velocidademinima = velocidademinima;
		this.velocidademaxima = velocidademaxima;
		this.fabricante = fabricante;
		this.Cor = cor;
	}
	public String getmodelo() {
		return modelo;
	}
	public double getvelocidademininma() {
		return velocidademinima;
	}
	public double getvelocidademaxima() {
		return velocidademaxima;
	}
	public String getfabricante() {
		return fabricante;
	}
	public String getCor() {
		return Cor;
	}
}

class carro extends veiculo{
	private String tipofreio;
	private String tipocombustivel;
	private int Cavalos;
	private int numerodelugares;
	carro(String freio,String combustivel, int cavalos, int lugares,String modelo,double velocidademinima,double velocidademaxima,String fabricante,String cor){
		super(modelo,velocidademinima,velocidademaxima,fabricante,cor);
		this.tipofreio = freio;
		this.tipocombustivel = combustivel;
		this.Cavalos = cavalos;
		this.numerodelugares = lugares;
}
	public String gettipofreio() {
		return tipofreio;
		
	}
	public String gettipocombustivel() {
		return tipocombustivel;
	}
	public int Cavalos() {
		return Cavalos;
	}
	public int numerodelugares() {
		return numerodelugares;
	}
	
	
}
class caminhao extends carro{
	private int numrodas;
	private boolean ca�amba;
	caminhao(String freio,String combustivel, int cavalos, int lugares,String modelo,double velocidademinima,double velocidademaxima,String fabricante,String cor,int rodas,boolean ca�amba){
		super( freio, combustivel, cavalos,  lugares, modelo, velocidademinima,velocidademaxima, fabricante,cor);
		this.numrodas = rodas;
		this.ca�amba = ca�amba;
	}
	public int getrodas() {
		return numrodas;
	}
	public void acoplarca�amba() {
		if(ca�amba == true) {
			System.out.println("Ca�amba j� acoplada");
		}
		else {
			this.ca�amba = true;
		}
	}
	public void desacoplarca�amba() {
		if(ca�amba == false) {
			System.out.println("Ca�amba j� desacoplada");
		}
		else {
			this.ca�amba = false;
		}
	}
}
