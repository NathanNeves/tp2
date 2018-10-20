package lista2;

import java.util.Scanner;

public class main {
	public static void main(String [] args) {
		int op = 0;
		Contabancaria conta = null;
		do {
		Scanner scan = new Scanner(System.in);	
		System.out.println("Sistema bancario");
		System.out.println("Digite 1 para cadastrar sua conta");
		System.out.println("Digite 2 para obter uma descrição da sua conta");
		System.out.println("Digite 3 para obter seu saldo");
		System.out.println("Digite 4 para  sacar uma quantia");
		System.out.println("Digite 5 para depositar uma quantia");
		System.out.println("Digite 6 para obter historico ");
		op = scan.nextInt();
		
		switch(op) {
	
		case 1:
			System.out.println("Digite seu nome:");
			String novonome = scan.next();
			System.out.print("Digite seu saldo inicial");
			Double novosaldo = scan.nextDouble();
			conta =  new Contabancaria(novosaldo,novonome);
			break;
		case 2:
			System.out.println(conta.contadescricao());
			break;
		case 3:
			System.out.println(conta.getsaldo());
			break;
		case 4:
			System.out.println("Digite quanto você deseja sacar");
			Double saque = scan.nextDouble();
			conta.realizarsaque(saque);
			break;
		case 5:
			System.out.println("Digite quanto você deseja depositar");
			Double dep = scan.nextDouble();
			conta.depositarquantia(dep);
			break;
		case 6:
			conta.retornarhistorico();
			break;
		
		}
			
		}while(op!=12);
	}
}
