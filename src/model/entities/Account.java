package model.entities;

import model.utility.Utility;

public class Account {

	private static int accountCount = 1;

	private int numberAccount;
	private Client client;
	private double balance;

	public Account(Client client) {
		this.numberAccount = accountCount;
		this.client = client;
		accountCount += 1;
	}
	public int getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(int numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "\nNumero da Conta: " + this.getNumberAccount()
		+ "\nNome: " + this.client.getName()
		+ "\nEmail: " + this.client.getEmail()
		+ "\nCPF: " + this.client.getCpf()
		+ "\nSaldo: " + Utility.doubleToString(this.getBalance());
	}
	public void deposit(double value) {
		if(value > 0) {
			setBalance(getBalance() + value);
			System.out.println("O deposito foi bem sucedido!");
		}else {
			System.out.println("Não foi possível efetuar o deposito");
		}
	}
	public void withdraw(double value) {
		if(value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			System.out.println("O saque foi efetuado com sucesso!");
		}else {
			System.out.println("Não foi possível efetuar o saque!");
		}
	}
	public void transfer(Account transferAccount, double value) {
		if(value > 0 && this.getBalance() >= value) {
			setBalance(getBalance() - value);
			transferAccount.balance = transferAccount.getBalance() + value;
			System.out.println("Transferência efetuada com sucesso!");
		}else {
			System.out.println("Transferência não efetuada!");
		}
	}
}
