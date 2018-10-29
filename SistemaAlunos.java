package projetonumeros;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projetonumeros.Posdoc.Turma;
class Disciplina{
	private String nome;
	private String codigo;
	private String ementa;
	private int cargasemanal;
	private Professor responsavel;
	private Turma turma = null;
	Disciplina(String nome,String codigo,String ementa,int carga,Professor professor){
		this.nome = nome;
		this.codigo  = codigo;
		this.ementa = ementa;
		this.cargasemanal = carga;

			}
	public void Setturma(Turma novaturma) {
		this.turma = novaturma;
	}
	public Professor getresponsavel() {
		return this.responsavel;
	}
	public Turma getturma() {
		return this.turma;
	}
	public String getnome() {
		return this.nome;
	}
	}
interface Academico{
	public boolean podesermonitor(Disciplina disciplina);
}
class Pessoa {
	protected String nome;
	protected Date datadenascimento;
	protected String login;
	Pessoa(String nome, String novonascimento) throws Exception{
		this.nome = nome;
		try {
			this.datadenascimento = DateFormat.getInstance().parse(novonascimento);
			}
			catch(Exception e){
				throw new Exception("Entrada de data invalida tente inserir como DD/MM/YYYY");
			}
		String[] loginarray = new String[3];
		loginarray = nome.split(" ");
		this.login = loginarray[0]+"."+loginarray[2]+"@uniriotec.br";
	}
	public String getnome() {
		return nome;
	}
	
	public Date getnascimento() {
		return this.datadenascimento;
	}
}
class Aluno extends Pessoa {
	private long matricula;
	private Double entrada;
	private String Curso;
	private Professor orientador;
	private ArrayList<Aluno> apadrinhados = new ArrayList<Aluno>();
	Aluno(String nome,String datadenascimento,String matricula, Double entrada,String Curso) throws Exception {
		super(nome,datadenascimento);
		this.Curso = Curso;
		if(matricula.length()==11) {
			this.matricula = Long.parseLong(matricula);
		}
		else {
			throw new Exception("Matricula invalida");
	}
		
		if(entrada>2000) {
			this.entrada = entrada;
		}
		else {
			throw new Exception("Ano de entrada invalido");
		}
	
	}
	public void addafilhado(Aluno aluno) {
		this.apadrinhados.add(aluno);
	}
	public void setorientador(Professor novoorientador) {
		this.orientador = novoorientador;
	}
	public Professor getorientador() {
		return orientador;
	}
	
	public String getlogin() {
		return this.login;
	}
}
class Alunopos extends Aluno implements Academico{
	private String titulotese;
	Alunopos(String titutese,String nome,String datadenascimento,String matricula, Double entrada,String Curso,Professor orientador) throws Exception{
		super(nome,datadenascimento,matricula,entrada,Curso);
		this.setorientador(orientador);
		this.titulotese = titutese;
	}
	public boolean podesermonitor(Disciplina disciplina) {
		if(disciplina.getresponsavel().getnome() == this.getorientador().getnome()) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Professor extends Pessoa implements Academico{
	private long siape;
	private String departamento;
	Professor(String newnome,String newnascimento,String newsiape, String newdepartamento) throws Exception{
			super(newnome,newnascimento);
			if(newsiape.length()==7) {
				this.siape = Long.parseLong(newsiape);
			}
			else {
				throw new Exception("Matricula invalida");
		}
			}
	public boolean podesermonitor(Disciplina disciplina) {
		if(disciplina.getresponsavel().getnome() != this.nome) {
			return true;
		}
		else {
			return false;
		}
	}
	public long getsiape() {
		return this.siape;
	}
}
class Posdoc implements Academico{
	private List<String> assuntos = new ArrayList<>();
	public boolean podesermonitor(Disciplina disciplina) {
		return true;
}

class Turma{
	private Double periodo;
	private Professor professorturma;
	private Academico monitor = null;
	private List<Aluno> alunos = new ArrayList<>();
	private Disciplina disciplina;
	Turma(Professor novoprofessorturma,Double periodo) throws Exception{
		if(periodo>2000) {
			this.periodo = periodo;
		}
		else {
			throw new Exception("Periodo invalido");
		}
		this.professorturma = novoprofessorturma;
		}
	public void setmonitor(Academico monitor) throws Exception {
		if(monitor.podesermonitor(this.disciplina) == true) {
			this.monitor = monitor;
		}
		else {
			throw new Exception("Monitor invalido");
		}
		
	}
	public void cadastraraluno(String nome,String datadenascimento,String matricula, Double entrada,String Curso) {
		try {
			alunos.add(new Aluno(nome,datadenascimento,matricula,entrada, Curso));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public Academico getmonitor() {
		return this.monitor;
	}}}
	
	
	

	

