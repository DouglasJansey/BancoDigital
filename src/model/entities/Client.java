package model.entities;

public class Client {
	
	private static int countId = 1;
	private String name;
	private String cpf;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Client(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		countId += 1;
	}
	public String toString() {
		return "\nNome: " + this.getName() 
			 + "\nEmail: " + this.getEmail()
			 + "\nCPF: " + this.getCpf();
	}
}
