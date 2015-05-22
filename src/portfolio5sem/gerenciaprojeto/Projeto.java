package portfolio5sem.gerenciaprojeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PROJETO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns=@JoinColumn(name="PROJETO_ID"))
	@Column
	private List<String> requisitos = new ArrayList<String>();
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns=@JoinColumn(name="PROJETO_ID"))
	@Column
	private List<String> tarefas = new ArrayList<String>();
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns=@JoinColumn(name="PROJETO_ID"))
	@Column
	private List<String> emdesenvolvimento = new ArrayList<String>();
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns=@JoinColumn(name="PROJETO_ID"))
	@Column
	private List<String> emteste = new ArrayList<String>();
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(joinColumns=@JoinColumn(name="PROJETO_ID"))
	@Column
	private List<String> aceito = new ArrayList<String>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(List<String> requisitos) {
		this.requisitos = requisitos;
	}
	public List<String> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<String> tarefas) {
		this.tarefas = tarefas;
	}
	public List<String> getEmdesenvolvimento() {
		return emdesenvolvimento;
	}
	public void setEmdesenvolvimento(List<String> emdesenvolvimento) {
		this.emdesenvolvimento = emdesenvolvimento;
	}
	public List<String> getEmteste() {
		return emteste;
	}
	public void setEmteste(List<String> emteste) {
		this.emteste = emteste;
	}
	public List<String> getAceito() {
		return aceito;
	}
	public void setAceito(List<String> aceito) {
		this.aceito = aceito;
	}
	
	public String toString() {
		return nome + "/" + id;
	}
	
}
