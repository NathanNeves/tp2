package projetonumeros;
import java.util.ArrayList;
import java.util.List;
public enum Posicao{
	Fixo ("fixo"), aladireito ("Ala direito"), alaesquerdo("Ala esquerdo"), pivo("Pivô"), goleiro("Goleiro");
	private String nomeposicao;
	Posicao(String nomeposicao){
		this.nomeposicao = nomeposicao;
	}
	public String getnomeposicao() {
		return this.nomeposicao;
	}
}
class Atleta{
	private String nome;
	private int idade;
	private double peso;
	private Posicao posicao;
	private Time time;
	Atleta(String name, int age, double weight,Time timejogador,Posicao posicao){
		this.nome = name;
		this.idade = age;
		this.peso = weight;
		this.time = timejogador;
	}
	public String getnome() {
		return this.nome;
	}
	public int getidade() {
		return this.idade;
	}
	public double getpeso() {
		return this.peso;
	}
	public String getposicao() {
		return posicao.getnomeposicao();
	}
}
class Time{
	private String nome;
	List<Atleta> atletas = new ArrayList<>();
	Time(String nome){
		this.nome = nome;
	}
	public void setnome(String novonome) {
		this.nome = novonome;
	}
	public void addjogador(String name,int age,double weight,Time timejogador, Posicao posicao) {
		atletas.add(new Atleta( name, age, weight,timejogador,posicao));
	}
	public void excluirjogador(String name) {
		for(Atleta jogador : atletas) {
				if(name != atletas.get(atletas.size()-1).getnome()) {
					System.out.println("Jogador não encontrado");
				}
			if (name == jogador.getnome()) {
				atletas.remove(jogador);
				System.out.println("Jogador removido com sucesso");
				break;
			}
			}
		}
	public String getnome() {
		return this.nome;
	}
	public void exibirtime() {
		for(Atleta jogador : atletas) {
			System.out.println("Nome do jogador: "+jogador.getnome()+" Peso: "+jogador.getpeso()+" Idade: "+jogador.getidade()+" Posição: "+jogador.getposicao());
		}
	}
}
class Partida{
	private Time time1;
	private Time time2;
	private int placarTime1;
	private int placarTime2;
	private Time vencedor;
	public void DefinirPartida(Time time1, Time time2) {
		this.time1 = time1;
		this.time2 = time2;
	}
	public void MarcarPontotime1(String nome) {
		if(nome == time1.getnome()) {
			placarTime1++;
		}
		else {
			System.out.println("Não foi possivel encontrar esse time");
		}
	}
	public void MarcarPontotime2(String nome) {
		if(nome == time2.getnome()) {
			placarTime2++;
		}
		else {
			System.out.println("Não foi possivel encontrar esse time");
		}
	}
	public String finalizarpartida() {
		if(this.placarTime1>this.placarTime2) {
			this.vencedor = time1;
			return "O time vencedor foi o "+this.vencedor.getnome()+" ele marcou "+this.placarTime1;
		}
		else if(this.placarTime1 == this.placarTime2) {
			return "O resultado foi empate";
		}
		else {
			this.vencedor = time2;
			return "O time vencedor foi o "+this.vencedor.getnome()+" ele marcou "+this.placarTime2;

		}
	}
}
class Campeonato {
	Time timevencedor;
	List<Partida> partidas = new ArrayList<>();
	List<Time> times = new ArrayList<>();
	private void addtime(String nometime) {
		times.add(new Time(nometime));
	}
} 
	
