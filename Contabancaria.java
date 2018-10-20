package lista2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Contabancaria {
	private double saldo;
	private String nomecorrentista;
	private long numerocorrentista;
	private int agencia;
	private List<String> historico = new ArrayList<>();
	Contabancaria(double saldo,String nome){
		this.saldo = saldo;
		this.nomecorrentista = nome;
		Random gerar = new Random();
		this.numerocorrentista = gerar.nextInt(30000);
		this.agencia = gerar.nextInt(500);
	}
	public String contadescricao() {
		return "==========="+" Descrição da conta "+"========="+"\n"+"Agencia: "+this.agencia+"\n"+"Conta: "+this.numerocorrentista+"\n"+"Correntista: "+this.nomecorrentista+"\n"+"============================";
	}
	public Double getsaldo() {
		return this.saldo;
	}
	public void realizarsaque(Double quantia) {
		if(this.saldo-quantia>=0) {
			this.saldo-=quantia;
			this.historico.add("Saque da quantia: "+quantia+"\n"+"Saldo atual: "+this.saldo);
		}
		else {
			System.out.println("Impossivel realizar o saque");
		}
	}
	public void depositarquantia(Double quantia) {
		this.saldo+=quantia;
		this.historico.add("Quantia de: "+quantia+" foi depositada "+" Saldo Atual:"+this.saldo);
	}
	public void retornarhistorico() {
		for(int i=1;i<4;i++) {
			if(historico.size()<i) {
			System.out.println("=================================");
			break;
			}
			else {
				System.out.println(this.historico.get(historico.size()-i));
			}
		}
	}
}


