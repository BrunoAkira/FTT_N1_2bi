package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	String nome, email;
	
	public Cliente(String nome, String email) {
		
		this.setNome(nome);
		this.setEmail(email);
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
