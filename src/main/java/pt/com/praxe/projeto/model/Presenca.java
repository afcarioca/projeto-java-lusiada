package pt.com.praxe.projeto.model;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Presencas")
public class Presenca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Aluno aluno;

	private String periodo;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dataPresenca;
	

	public Date getDataPresenca() {
		return dataPresenca;
	}

	public void setDataPresenca(Date dataPresenca) {
		this.dataPresenca = dataPresenca;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
