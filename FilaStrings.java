package lista2;
import java.util.ArrayList;
import java.util.List;

public class FilaStrings {
	private List<String> historico = new ArrayList<>();
	FilaStrings(ArrayList<String> historico){
		this.historico = historico;
	}
	public String ocupaatual() {
		return "A ocupação atual possui "+this.historico.size() + " Elementos ";
	}
	public void addString(String dado) {
		this.historico.add(dado);
	}
	public String returninicio() {
		return this.historico.get(0);
	}
	public String removeinicio() {
		return this.historico.remove(0);
	}
	public static void main(String [] args) {
		ArrayList<String> lis = new ArrayList<>();
		lis.add("1");
		lis.add("2");
		lis.add("3");
		lis.add("4");
		lis.add("5");
		FilaStrings fila = new FilaStrings(lis);
		System.out.println(fila.ocupaatual());
		fila.addString("6");
		System.out.println(lis.toString());
		fila.removeinicio();
		System.out.println(lis.toString());
		System.out.println(fila.returninicio());
		fila.removeinicio();
		System.out.println(lis.toString());
		
	}
}
