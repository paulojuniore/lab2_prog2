package lab2.paulo_junior;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um aluno matriculado na UFCG
 * 
 * @author Paulo Mendes da Silva Júnior
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
	 * Representa todas as contas de laboratório que o aluno possui
	 */
	private List<ContaLaboratorio> laboratorios;
	
	/**
	 * Representa a saúde de um aluno
	 */
	private Saude saude = new Saude();
	
	/**
	 * Constrói um aluno que possui disciplinas, contas de cantina e contas de laboratório
	 */
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
		this.cantinas = new ArrayList<ContaCantina>();
		this.laboratorios = new ArrayList<ContaLaboratorio>();
	}
	
	/**
	 * Cadastra um novo laboratório com valores padrão a um aluno.
	 * 
	 * @param nomeLaboratorio : nome do novo laboratório que será inserido na Lista
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		laboratorios.add(new ContaLaboratorio(nomeLaboratorio));
	}
	
	/**
	 * Cadastra um novo laboratório com uma cota informada pelo usuário. (valor inteiro)
	 * 
	 * @param nomeLaboratorio : nome do novo laboratório que será inserido na Lista
	 * @param cota : cota máxima do laborório criado
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		laboratorios.add(new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	/**
	 * Consome certa quantidade de memória do espaço disponível na conta. Espera-se um valor menor que
	 * o limite disponível.
	 * 
	 * @param nomeLaboratorio : nome do laboratório que será modificado
	 * @param mBytes : quantidade a ser consumida
	 */
	public void consomeEspaco(String nomeLaboratorio, int mBytes) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		contaLab.consomeEspaco(mBytes);
	}
	
	/**
	 * Libera certa quantidade de memória do espaço disponível na conta. Espera-se um valor menor ou igual 
	 * ao que está sendo utilizado no momento.
	 * 
	 * @param nomeLaboratorio : nome do laboratório que será modificado
	 * @param mBytes : quantidade a ser liberada
	 */
	public void liberaEspaco(String nomeLaboratorio, int mBytes) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		contaLab.liberaEspaco(mBytes);
	}
	
	/**
	 * Verifica se a conta em questão atingiu o limite estabelecido/padrão de cota
	 * 
	 * @param nomeLaboratorio : nome do laboratório que será modificado
	 * @return : retorna se a conta teve ou não seu limite atingido através de um boolean (true/false)
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio contaLab = procuraConta(nomeLaboratorio);
		return contaLab.atingiuCota();
	}
	
	/**
	 * Busca no Array de Contas de Laboratório se contém a nota buscada
	 * 
	 * @param nomeLaboratorio : nome do lab a ser procurado
	 * 
	 * @return : uma conta de laboratório
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
	 * Retorna uma Lista de Contas de Laboratório de um aluno
	 * 
	 * @param nomeLaboratorio : Nome do laboratório a ser mostrado
	 * 
	 * @return : as contas de laboratório cadastradas de um aluno
	 */
	public String laboratoriosToString(String nomeLaboratorio) {
		ContaLaboratorio laboratorio = procuraConta(nomeLaboratorio);
		return laboratorio.toString();
	}
	
	/**
	 * Cadastra uma nova disciplina com um nome.
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser cadastrada
	 * @param num : número de notas no diário de classe
	 * @param pesos : array de pesos para cada uma das notas do diário. OBS: assume-se que o número de pesos é igual
	 * ao número de notas
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
	 * Cadastra Notas de uma disciplina em uma posição específica do array de notas
	 * 
	 * @param nomeDisciplina : nome da disciplina a ser alterada
	 * @param nota : posição do array a ser inserida a nota, assume-se que a nota estará numa posição válida do array
	 * @param valorNota : valor da nota
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		Disciplina disciplina = procuraDisciplina(nomeDisciplina);
		disciplina.cadastraNota(nota, valorNota);
	}
	
	/**
	 * Retorna a indicação se o aluno foi Aprovado ou não.
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
	 * Busca no Array de Disciplinas se contém a disciplina buscada
	 * 
	 * @param nomeLaboratorio : nome do lab a ser procurado
	 * 
	 * @return : uma disciplina específica
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
	 * Cadastra uma compra de lanche numa determinada cantina já cadastrada
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
	 * Paga a conta de um aluno na Cantina, assume-se que o valor será menor ou igual que o débito
	 * 
	 * @param nomeCantina : o nome da cantina
	 * @param valorCentavos : valor a ser retirado do débito total
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		ContaCantina cantina = procurarCantina(nomeCantina);
		cantina.pagaConta(valorCentavos);
	}
	
	/**
	 * Busca no Array de Contas de Cantina se contém a cantina buscada
	 * 
	 * @param nomeCantina : nome da cantina a ser buscada
	 * 
	 * @return : uma cantina específica
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
	 * @return : uma representação String das contas de cantina de um aluno
	 */
	public String cantinaToString(String nomeCantina) {
		ContaCantina cantina = procurarCantina(nomeCantina);
		return cantina.toString();
	}
	
	/**
	 * Define a saúde mental de um aluno
	 * 
	 * @param valor : String "boa" ou "fraca" que representa o estado atual do aluno
	 */
	public void defineSaudeMental(String valor) {
		saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a saúde física de um aluno
	 * 
	 * @param valor String "boa" ou "fraca" que representa o estado atual do aluno
	 */
	public void defineSaudeFisica(String valor) {
		saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Retorna o status geral do aluno
	 * 
	 * @return : status geral da saúde do aluno
	 */
	public String getStatusGeral() {
		return saude.getStatusGeral();
	}
}
