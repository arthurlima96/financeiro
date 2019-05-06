package principal;

import java.io.Serializable;

public class Aluno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5118780000228895440L;
	private String nome;
	private String cpf;
	private int matricula;
	private String curso;
	private String mensalidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(String mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	
}
