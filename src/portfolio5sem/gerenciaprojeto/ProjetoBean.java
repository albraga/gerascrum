package portfolio5sem.gerenciaprojeto;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProjetoBean {

	private Projeto projeto;
	private String requisitoString;
	private String[] reqArray;
	@SuppressWarnings("unused")
	private List<Projeto> projetos;
	private String nomeProjetoSelecionado;
	private Projeto projetoSelecionado = null;
	private String novoRequisito;
	private String nomeRequisitoSelecionado;
	private String novaTarefa;
	private String nomeTarefaSelecionada;
	private String nomeTarefaSelecionadaEmDesenvolvimento;
	private String nomeTarefaSelecionadaEmTeste;

	public ProjetoBean() {
		projeto = new Projeto();
	}
	
	public String enviarParaEmDesenvolvimento() {
		projetoSelecionado.getEmdesenvolvimento().add(nomeTarefaSelecionada);
		projetoSelecionado.getTarefas().remove(nomeTarefaSelecionada);
		new ProjetoDAO().update(projetoSelecionado);
		return "editar?faces-redirect=true";
	}
	
	public String enviarParaEmTeste() {
		projetoSelecionado.getEmteste().add(nomeTarefaSelecionadaEmDesenvolvimento);
		projetoSelecionado.getEmdesenvolvimento().remove(nomeTarefaSelecionadaEmDesenvolvimento);
		new ProjetoDAO().update(projetoSelecionado);
		return "editar?faces-redirect=true";
	}
	
	public String enviarParaAceito() {
		projetoSelecionado.getAceito().add(nomeTarefaSelecionadaEmTeste);
		projetoSelecionado.getEmteste().remove(nomeTarefaSelecionadaEmTeste);
		new ProjetoDAO().update(projetoSelecionado);
		return "editar?faces-redirect=true";
	}
	
	public String salvarNovaTarefa() {
		projetoSelecionado.getTarefas().add(novaTarefa);
		new ProjetoDAO().update(projetoSelecionado);
		novaTarefa = "";
		return "editar?faces-redirect=true";
	}
	
	public String salvarNovoRequisito() {
		projetoSelecionado.getRequisitos().add(novoRequisito);
		new ProjetoDAO().update(projetoSelecionado);
		novoRequisito = "";
		return "editar?faces-redirect=true";
	}
	
	public String enviarParaSprint() {
		projetoSelecionado.getTarefas().add(nomeRequisitoSelecionado);
		projetoSelecionado.getRequisitos().remove(nomeRequisitoSelecionado);
		new ProjetoDAO().update(projetoSelecionado);
		return "editar?faces-redirect=true";
	}
	
	public String editar() {
		Long id = Long.valueOf(nomeProjetoSelecionado.split("/")[1]);
		projetoSelecionado = get(id);
		return "editar?faces-redirect=true";
	}

	public String salvarNovo() {
		if (requisitoString.split(";").length > 0) {
			reqArray = requisitoString.split(";");
		} else {
			reqArray[0] = requisitoString;
		}
		projeto.getRequisitos().addAll(Arrays.asList(reqArray));
		save(projeto);
		clear();
		return "index";
	}
	
	private void clear() {
		requisitoString = "";
		projeto.setNome("");
	}

	public void save(Projeto projeto) {
		new ProjetoDAO().save(projeto);
	}

	public List<Projeto> getAll() {
		return new ProjetoDAO().getAll();
	}

	public void delete(Long id) {
		new ProjetoDAO().delete(id);
	}

	public Projeto get(Long id) {
		return new ProjetoDAO().get(id);
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getRequisitoString() {
		return requisitoString;
	}

	public void setRequisitoString(String requisitoString) {
		this.requisitoString = requisitoString;
	}

	public List<Projeto> getProjetos() {
		return new ProjetoDAO().getAll();
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public String getNomeProjetoSelecionado() {
		return nomeProjetoSelecionado;
	}

	public void setNomeProjetoSelecionado(String nomeProjetoSelecionado) {
		this.nomeProjetoSelecionado = nomeProjetoSelecionado;
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

	public String getNovoRequisito() {
		return novoRequisito;
	}

	public void setNovoRequisito(String novoRequisito) {
		this.novoRequisito = novoRequisito;
	}

	public String getNomeRequisitoSelecionado() {
		return nomeRequisitoSelecionado;
	}

	public void setNomeRequisitoSelecionado(String nomeRequisitoSelecionado) {
		this.nomeRequisitoSelecionado = nomeRequisitoSelecionado;
	}

	public String getNovaTarefa() {
		return novaTarefa;
	}

	public void setNovaTarefa(String novaTarefa) {
		this.novaTarefa = novaTarefa;
	}

	public String getNomeTarefaSelecionada() {
		return nomeTarefaSelecionada;
	}

	public void setNomeTarefaSelecionada(String nomeTarefaSelecionada) {
		this.nomeTarefaSelecionada = nomeTarefaSelecionada;
	}

	public String getNomeTarefaSelecionadaEmDesenvolvimento() {
		return nomeTarefaSelecionadaEmDesenvolvimento;
	}

	public void setNomeTarefaSelecionadaEmDesenvolvimento(
			String nomeTarefaSelecionadaEmDesenvolvimento) {
		this.nomeTarefaSelecionadaEmDesenvolvimento = nomeTarefaSelecionadaEmDesenvolvimento;
	}

	public String getNomeTarefaSelecionadaEmTeste() {
		return nomeTarefaSelecionadaEmTeste;
	}

	public void setNomeTarefaSelecionadaEmTeste(
			String nomeTarefaSelecionadaEmTeste) {
		this.nomeTarefaSelecionadaEmTeste = nomeTarefaSelecionadaEmTeste;
	}

	
}
