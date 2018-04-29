package lab2.paulo_junior;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um aluno matriculado na UFCG
 * 
 * @author Paulo Mendes da Silva J�nior
 *
 */

public class Aluno {

	/**
	 * Representa todas as disciplinas de um aluno
	 */
	private List<Disciplina> disciplinas;
	
	/**
	 * Representa todas as contas de cantina que o aluno possui
	 */
	private List<ContaCantina> cantinas;
	
	/**
	 * Representa todas as contas de laborat�rio que o aluno possui
	 */
	private List<ContaLaboratorio> laboratorios;
	
	/**
	 * Representa a sa�de de um aluno
	 */
	private Saude saude = new Saude();
	
	/**
	 * Constr�i um aluno que possui disciplinas, contas de cantina e contas de laborat�rio
	 */
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.cantinas = new ArrayList<ContaCantina>();
		this.laboratorios = new ArrayList<ContaLaboratorio>();
	}
	
	/**
	 * Cadastra um novo laborat�rio com valores padr�o a um aluno.
	 * 
	 * @param nomeLaboratorio : nome do novo laborat�rio que ser� inserido na Lista
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		laboratorios.add(new ContaLaboratorio(nomeLaboratorio));
	}
	
	/**
	 * Cadastra um novo laborat�rio com uma cota informada pelo usu�rio. (valor inteiro)
	 * 
	 * @param nomeLaboratorio : nome do novo laborat�rio que ser� inserido na Lista
	 * @param cota : cota m�xima do labor�rio criado
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		laboratorios.add(new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	/**
	 * Consome certa quantidade de mem�ria do espa�o dispon�vel na conta. Espera-se um valor menor que
	 * o limite dispon�vel.
	 * 
	 * @param nomeLaboratorio : nome do laborat�rio que ser� modificado
	 * @param mBytes : quantidade a ser consumida
	 */
	public void consomeEspaco(String nomeLaboratorio, int mBytes) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		contaLab.consomeEspaco(mBytes);
	}
	
	/**
	 * Libera certa quantidade de mem�ria do espa�o dispon�vel na conta. Espera-se um valor menor ou igual 
	 * ao que est� sendo utilizado no momento.
	 * 
	 * @param nomeLaboratorio : nome do laborat�rio que ser� modificado
	 * @param mBytes : quantidade a ser liberada
	 */
	public void liberaEspaco(String nomeLaboratorio, int mBytes) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		contaLab.liberaEspaco(mBytes);
	}
	
	/**
	 * Verifica se a conta em quest�o atingiu o limite estabelecido/padr�o de cota
	 * 
	 * @param nomeLaboratorio : nome do laborat�rio que ser� modificado
	 * @return : retorna se a conta teve ou n�o seu limite atingido atrav�s de um boolean (true/false)
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		return contaLab.atingiuCota();
	}
	
	/**
	 * Busca no Array de Contas de Laborat�rio se cont�m a nota buscada
	 * 
	 * @param nomeLaboratorio : nome do lab a ser procurado
	 * 
	 * @return : uma conta de laborat�rio
	 */
	private ContaLaboratorio procuraConta(String nomeLaboratorio) {
		for(int i = 0; i < laboratorios.size(); i++) {
			ContaLaboratorio conta = laboratorios.get(i);
			if(conta.getNomeLab().equals(nomeLaboratorio)) {
				return conta;
			}
		}
		return null;
	}
	
	/**
	 * Retorna uma Lista de Contas de Laborat�rio de um aluno
	 * 
	 * @param nomeLaboratorio : Nome do laborat�rio a ser mostrado
	 * 
	 * @return : as contas de laborat�rio cadastradas de um aluno
	 */
	public String laboratoriosToString(String nomeLaboratorio) {
		ContaLaboratorio laboratorio = procuraConta(nomeLaboratorio);
		return laboratorio.toString();
	}
	
	/**
	 * Cadastra uma nova disciplina com um nome.
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser cadastrada
	 * @param num : n�mero de notas no di�rio de classe
	 * @param pesos : array de pesos para cada uma das notas do di�rio. OBS: assume-se que o n�mero de pesos � igual
	 * ao n�mero de notas
	 */
	public void cadastraDisciplina(String nomeDisciplina, int num, int[] pesos) {
		disciplinas.add(new Disciplina(nomeDisciplina, num, pesos));
	}
	
	/**
	 * Cadastra horas de estudo em uma disciplina
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser alterada
	 * @param horas : horas de estudos aplicadas na disciplina
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		Disciplina disciplina = procuraDisciplina(nomeDisciplina);
		disciplina.cadastraHoras(horas);
	}
	
	/**
	 * Cadastra Notas de uma disciplina em uma posi��o espec�fica do array de notas
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser alterada
	 * @param nota : posi��o do array a ser inserida a nota, assume-se que a nota estar� numa posi��o v�lida do array
	 * @param valorNota : valor da nota
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		Disciplina disciplina = procuraDisciplina(nomeDisciplina);
		disciplina.cadastraNota(nota, valorNota);
	}
	
	/**
	 * Retorna a indica��o se o aluno foi Aprovado ou n�o.
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser consultada
	 * 
	 * @return : (true/false) indicando se o aluno foi aprovado ou reprovado, respectivamente.
	 */
	public boolean aprovado(String nomeDisciplina) {
		Disciplina disciplina = procuraDisciplina(nomeDisciplina);
		return disciplina.aprovado();
	}
	
	/**
	 * Busca no Array de Disciplinas se cont�m a disciplina buscada
	 * 
	 * @param nomeLaboratorio : nome do lab a ser procurado
	 * 
	 * @return : uma disciplina espec�fica
	 */
	private Disciplina procuraDisciplina(String nomeDisciplina) {
		for(int i = 0; i < disciplinas.size(); i++) {
			Disciplina disciplina = disciplinas.get(i);
			if(disciplina.getNomeDisciplina().equals(nomeDisciplina)) {
				return disciplina;
			}
		}
		return null;
	}
	
	/**
	 * Retorna uma lista de disciplinas de um aluno
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser mostrada
	 * 
	 * @return : lista de disciplinas de um aluno
	 */
	public String disciplinaToString(String nomeDisciplina) {
		Disciplina disciplina = procuraDisciplina(nomeDisciplina);
		return disciplina.toString();
	}
	
	/**
	 * Cadastra uma conta de cantina para um aluno
	 * 
	 * @param nomeCantina : o nome da cantina a ser cadastrada
	 */
	public void cadastraCantina(String nomeCantina) {
		cantinas.add(new ContaCantina(nomeCantina));
	}
	
	/**
	 * Cadastra uma compra de lanche numa determinada cantina j� cadastrada
	 * 
	 * @param nomeCantina : o nome da cantina
	 * @param qtdItens : a quantidade de itens que foram comprados
	 * @param valorCentavos : o valor total da compra
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		ContaCantina cantina = procurarCantina(nomeCantina);
		cantina.cadastrarLanche(qtdItens, valorCentavos);
	}
	
	/**
	 * Paga a conta de um aluno na Cantina, assume-se que o valor ser� menor ou igual que o d�bito
	 * 
	 * @param nomeCantina : o nome da cantina
	 * @param valorCentavos : valor a ser retirado do d�bito total
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		ContaCantina cantina = procurarCantina(nomeCantina);
		cantina.pagaConta(valorCentavos);
	}
	
	/**
	 * Busca no Array de Contas de Cantina se cont�m a cantina buscada
	 * 
	 * @param nomeCantina : nome da cantina a ser buscada
	 * 
	 * @return : uma cantina espec�fica
	 */
	private ContaCantina procurarCantina(String nomeCantina) {
		for(int i = 0; i < cantinas.size(); i++) {
			ContaCantina cantina = cantinas.get(i);
			if(cantina.getNomeCantina().equals(nomeCantina)) {
				return cantina;
			}
		}
		return null;
	}
	
	/**
	 * Retorna uma lista de contas de cantina de um aluno
	 * 
	 * @param nomeCantina : o nome da cantina
	 * 
	 * @return : uma representa��o String das contas de cantina de um aluno
	 */
	public String cantinaToString(String nomeCantina) {
		ContaCantina cantina = procurarCantina(nomeCantina);
		return cantina.toString();
	}
	
	/**
	 * Define a sa�de mental de um aluno
	 * 
	 * @param valor : String "boa" ou "fraca" que representa o estado atual do aluno
	 */
	public void defineSaudeMental(String valor) {
		saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a sa�de f�sica de um aluno
	 * 
	 * @param valor String "boa" ou "fraca" que representa o estado atual do aluno
	 */
	public void defineSaudeFisica(String valor) {
		saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Retorna o status geral do aluno
	 * 
	 * @return : status geral da sa�de do aluno
	 */
	public String getStatusGeral() {
		return saude.getStatusGeral();
	}
}
