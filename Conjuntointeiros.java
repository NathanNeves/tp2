package lista2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Conjuntointeiros {
	private ArrayList<Integer> conjunto = new ArrayList<>();
	Conjuntointeiros(ArrayList<Integer> inteiro){
		this.conjunto = inteiro;
	}
	public ArrayList<Integer> getconjunto(){
			return this.conjunto;
	}
	public void addcon(int num) {
		if(this.conjunto.contains(num) == true) {
			System.out.println("Esse número já existe no conjunto");
		}
		else {
		this.conjunto.add(num);
		}
	}
	public void removecon(int num) {
		if(this.conjunto.contains(num) == true) {
			this.conjunto.remove(num);
			}
		else {
			System.out.println("Esse número não existe no conjunto");
		}
	}
	public int cardinalidade() {
		return this.conjunto.size();
	}
	public String uniao(ArrayList<Integer> conj) {
		ArrayList<Integer> uni = new ArrayList<>();
		ArrayList<Integer> conjclone = new ArrayList<>();
		conjclone.addAll(conj);
		for(int number: conjclone ) {
			if(this.conjunto.contains(number) == true) {
				conjclone.remove(conj.indexOf(number));
			}
		}
		uni.addAll(conjclone);
		uni.addAll(this.conjunto);
		return uni.toString();
	}
	public String inter(ArrayList<Integer> conj) {
		ArrayList<Integer> inter  = new ArrayList<Integer>(); 
		for(int number: conj ) 
		{
			if(this.conjunto.contains(number) == true) {
				inter.add(number);
		}
	}
	return inter.toString();
	}
	public String dif(ArrayList<Integer> conj) {
		ArrayList<Integer> dif = new ArrayList<Integer>();
		for(int number:	conj ) 
		{
			if(this.conjunto.contains(number) == false) {
				dif.add(number);
		}
	}
	return dif.toString();
	}
	public boolean subcon(ArrayList<Integer> conj) {
		if(this.conjunto.containsAll(conj) == true) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean iguais(ArrayList<Integer> conj) {
		if(this.conjunto.size() == conj.size() && this.conjunto.contains(conj)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void descr() {
		System.out.println("Comprimento "+this.conjunto.size());
		
		for(int num: this.conjunto) 
		{	if(this.conjunto.indexOf(num) == this.conjunto.size()-1) {
				System.out.println(num+"}");
			}
			else if(this.conjunto.indexOf(num) == 0) {
				System.out.print("{"+num+",");
			}
			else {System.out.print(num+",");}
			
		}
}
	public static void main(String[] args) {
		ArrayList<Integer> conj1 = new ArrayList<Integer>();
		ArrayList<Integer> conj2 = new ArrayList<Integer>();
		Conjuntointeiros conjunto = new Conjuntointeiros(conj1);
		Conjuntointeiros conjunto2 = new Conjuntointeiros(conj2);
		int op = 0;
		do {System.out.println("Digite 1 para adicionar um numero aos conjuntos");
			System.out.println("Digite 2 para remover um numero dos conjuntos");
			System.out.println("Digite 3 para verificar se um conjunto é subconjunto do outro");
			System.out.println("Digite 4 para calcular a uniao dos conjuntos");
			System.out.println("Digite 5 para calcular a interseção dos conjuntos");
			System.out.println("Digite 6 para calcular a subtração dos conjuntos");
			System.out.println("Digite 7 para obter uma descrição dos conjuntos");
			System.out.println("Digite 8 para obter a cardinalidade de um conjunto");
			System.out.println("Digite 9 para verificar se os conjuntos são iguais");
			Scanner scan = new Scanner(System.in);
			op = scan.nextInt();
			switch(op){
			case 1:
				int num;
				int selecao;
				System.out.println("1-Conjunto1");
				System.out.println("2-conjunto2");
				selecao = scan.nextInt();
				if(selecao==1) {
					System.out.println("Digite um numero para ser adicionado:");
					num = scan.nextInt();
					conjunto.addcon(num);
					break;
				}
				else if(selecao == 2){
					System.out.println("Digite um numero para ser adicionado:");
					num = scan.nextInt();
					conjunto2.addcon(num);
					break;
				}
			case 2:
				int num2;
				int selecao2;
				System.out.println("1-Conjunto1");
				System.out.println("2-conjunto2");
				selecao2 = scan.nextInt();
				if(selecao2==1) {
					System.out.println("Digite um numero para ser adicionado:");
					num2 = scan.nextInt();
					conjunto.removecon(num2);;
					break;
				}
				else if(selecao2 == 2){
					System.out.println("Digite um numero para ser adicionado:");
					num2 = scan.nextInt();
					conjunto2.removecon(num2);
					break;
				}
				else {
					System.out.println("Opção invalida");
					break;
				}
			case 3:
				int selecao3;
				System.out.println("2-Conjunto1 é subconjunto de Conjunto2");
				System.out.println("1-Conjunto2 é subconjunto de Conjunto1 ");
				selecao3 = scan.nextInt();
				if(selecao3==1) {
					if(conjunto.subcon(conjunto2.getconjunto()) == true) {
						System.out.println("A afirmativa é verdadeira ");
						break;
					}
					else {
						System.out.println("A afirmativa é falsa");
						break;
					}
				}
				else if(selecao3==2) {
					if(conjunto2.subcon(conjunto.getconjunto()) == true) {
						System.out.println("A afirmativa é verdadeira ");
						break;
					}
					else {
						System.out.println("A afirmativa é falsa");
						break;
					}
				}
				else {
					System.out.println("Opção invalida");
					break;
				}
			case 4:
					System.out.println(conjunto.uniao(conjunto2.getconjunto()));
					break;
				
			case 5: 
					System.out.println((conjunto.inter(conjunto2.getconjunto())));
					break;
			case 6:
					int selecao4;
				 	System.out.println("1-Conjunto1 menos Conjunto2");
				 	System.out.println("2-Conjunto2 menos Conjunto1");
				 	selecao4 = scan.nextInt();
					if(selecao4==1) {
						System.out.println(conjunto.dif(conjunto2.getconjunto()));
						break;
					}
					else if(selecao4==2) {
						System.out.println(conjunto2.dif(conjunto.getconjunto()));
						break;
					}
					else {
						System.out.println("Opção invalida");
						break;
					}
			case 7:
				int selecao5;
			 	System.out.println("1-descrição conjunto1");
			 	System.out.println("2-descrição conjunto2");
			 	selecao5 = scan.nextInt();
				if(selecao5==1) {
					conjunto.descr();
					break;
				}
				else if(selecao5==2) {
					conjunto2.descr();
					break;
				}
				else {
					System.out.println("Opção invalida");
					break;
				}
			case 8:
				int selecao6;
			 	System.out.println("1-cardinalidade conjunto1");
			 	System.out.println("2-cardinalidade conjunto2");
			 	selecao6 = scan.nextInt();
				if(selecao6==1) {
					System.out.println(conjunto.cardinalidade());
					break;
				}
				else if(selecao6==2) {
					System.out.println(conjunto2.cardinalidade());
					break;
				}
				else {
					System.out.println("Opção invalida");
					break;
				
			}
			case 9:
				if(conjunto.iguais(conjunto2.getconjunto())== true) {
					System.out.println("Os conjuntos são iguais");
					break;
				}
				else {
					System.out.println("Os conjuntos são diferentes");
					break;
				}
			}
			
			
				
		}while(op!=12);
	}
	}

