package model.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Account> bankAccount;

	public static void main(String[] args) {
		bankAccount = new ArrayList<Account>();
		operations();
	}

	public static void operations() {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("---------------------Bem vindos a nossa Agência-------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("************** Selecione uma operação que deseja realizar **************");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta  |");
		System.out.println("|   Opção 2 - Depositar    |");
		System.out.println("|   Opção 3 - Sacar        |");
		System.out.println("|   Opção 4 - Transferir   |");
		System.out.println("|   Opção 5 - Listar       |");
		System.out.println("|   Opção 6 - Sair         |");
		int operation = input.nextInt();
		
		switch (operation) {
		case 1:
			creatAccount();
			break;
		case 2:
			deposit();
			break;
		case 3:
			withdraw();
			break;
		case 4:
			transfer();
			break;
		case 5:
			show();
			break;
		case 6:
			System.out.println("Obrigado por utilizar nosso banco");
			System.exit(0);
			break;
			default:
				System.out.println("Opção inválida");
				operations();
		}
	}


	public static void show() {
		if(bankAccount.size() > 0) {
			for(Account account: bankAccount) {
				System.out.println(account);
			}
		}else {
			System.out.println("Não há contas cadastradas!");
		}
	operations();	
	}

	public static void creatAccount() {
		
		System.out.println("Nome: ");
		String name = input.next();
		
		System.out.println("CPF: ");
		String cpf = input.next();
	
		System.out.println("Email: ");
		String email = input.next();
		
		Client client = new Client(name, cpf, email);
		
		Account account = new Account(client);
		
		bankAccount.add(account);
		System.out.println("Sua conta foi criada com sucesso!");
		
	operations();	
	}
	
	public static Account accountSearch(int accountNumber) {
		Account account = null;
		if(bankAccount.size() > 0) {
			for(Account ac : bankAccount) {
				if(ac.getNumberAccount() == accountNumber) {
					account = ac;
				}
			}
		}
		return account;
	}
	public static void deposit() {
		System.out.println("\nNúmero da conta: ");
		int accountNumber = input.nextInt();
		
		Account account = accountSearch(accountNumber);
		
		if(account != null) {
			System.out.println("Qual valor deseja depositar?");
			double depositValue = input.nextDouble();
			account.deposit(depositValue);
			System.out.println("O valor foi depositado!");
		}else {
			System.out.println("Conta não encontrada!");
		}
		operations();
	}
	public static void withdraw() {
		System.out.println("\nNúmero da conta: ");
		int accountNumber = input.nextInt();
		
		Account account = accountSearch(accountNumber);
		
		if(account != null) {
			System.out.println("Qual valor deseja sacar?");
			double depositValue = input.nextDouble();
			account.withdraw(depositValue);
			System.out.println("Saque efetuado com sucesso!");
		}else {
			System.out.println("Conta não encontrada!");
		}
		operations();
		
		
	}

	public static void transfer() {
		System.out.println("Qual número da conta de quem vai enviar?");
		int accountNumberDeposit = input.nextInt();
		
		Account account = accountSearch(accountNumberDeposit);
		
		if(account != null) {
			System.out.println("Qual número da conta de quem vai receber?");
			int accountDeposit = input.nextInt();
			
			Account depositAccount = accountSearch(accountDeposit);
			
			if(depositAccount != null) {
				System.out.println("Qual valor será transferido?");
				double value = input.nextDouble();
				
				depositAccount.transfer(depositAccount, value);
			}else {
				System.out.println("Conta não encontrada!");
			}
		}else {
			System.out.println("Conta não encontrada!");
		}
		operations();
	}

}
