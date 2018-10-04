package exercicios;
public enum posicao{
	Fixo ("fixo"), aladireito ("Ala direito"), alaesquerdo("Ala esquerdo"), pivo("Pivô"), golerio("Goleiro");
	private String nomeposicao;
	posicao(String nomeposicao){
		this.nomeposicao = nomeposicao;
	}
}
class atleta{
	private String nome;
	private int idade;
	private double peso;
	private String posicao;
	private Time time;
	atleta(String name, int age, double weight,Time timejogador){
		this.nome = name;
		this.idade = age;
		this.peso = weight;
		this.time = timejogador;
	}
}
class Time{
	
}