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
	Atleta(String name, int age, double weight,Time timejogador,Posicao posicao){
		this.nome = name;
		this.idade = age;
		this.peso = weight;
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
	Partida(Time time1, Time time2) {
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
	public Time gettime1() {
		return time1;
	}
	public Time gettime2() {
		return time2;
	}
}
//modelo de campeonato no estilo mata-mata, cujo qual não é possivel dois times jogarem duas vezes
class Campeonato {
	Time timevencedor;
	List<Partida> partidas = new ArrayList<>();
	List<Time> times = new ArrayList<>();
	public void addtime(Time time) {
		times.add(time);
	}
	public void addpartida(Partida partida) {
		partidas.add(partida);
	}
	public void procurarpartida(String nometime1, String nometime2) {
		for(Partida partida : partidas) {
			if(nometime1 == partida.gettime1().getnome() && nometime2 == partida.gettime2().getnome()) {
				System.out.println(partida.finalizarpartida());
				break;
			}
			else if(nometime1 == partidas.get(partidas.size()-1).gettime1().getnome()&& nometime2 == partidas.get(partidas.size()-1).gettime2().getnome()) {
				System.out.println("Partida não encontrada");
			}
		}
	}
	public void definirtimevencedor(String nometimevencedor) {
		for(Time time: times) {
			if(nometimevencedor == time.getnome()) {
				this.timevencedor = time;
				break;
			}
			else if(nometimevencedor == times.get(times.size()-1).getnome()) {
				System.out.println("Impossivel encontrar esse time");
			}
		}
	} 
} 
	
