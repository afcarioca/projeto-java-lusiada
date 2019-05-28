package pt.com.praxe.projeto.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private List<Presenca> presencas = new ArrayList<>();

	private String nome;
	private String numeroDeAluno;
//	private int numeroDeInscricao;

	private String curso;

	private String telemovel;
	private String localidade;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dataNascimento;

	private String deslocamento;
	private String saude;
	private String observacoes;

//	public Aluno() {
//		this.presencas = new ArrayList<>();
//	}

	public String getTelemovel() {
		return telemovel;
	}

	public String getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(String deslocamento) {
		this.deslocamento = deslocamento;
	}

	public String getSaude() {
		return saude;
	}

	public void setSaude(String saude) {
		this.saude = saude;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setTelemovel(String telemovel) {
		this.telemovel = telemovel;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setNumeroDeAluno(String numeroDeAluno) {
		this.numeroDeAluno = numeroDeAluno;
	}

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

	public String getNumeroDeAluno() {
		return numeroDeAluno;
	}

	public void setNumero(String numeroDeAluno) {
		this.numeroDeAluno = numeroDeAluno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Presenca> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}

	public void setPresenca(Presenca presenca) {
		this.presencas.add(presenca);
	}

}
