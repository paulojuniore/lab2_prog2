package lab2.paulo_junior;

import java.util.Arrays;

/**
* Representa��o de uma Disciplina de um aluno matriculado na UFCG, do curso de Ci�ncia da Computa��o.
* Toda disciplina possui um nome, uma quantidade de horas associadas e v�rias notas.
* 
* @author Paulo Mendes da Silva J�nior - 117210922
*/

public class Disciplina 
{
	/**
	 * Nome da Disciplina � associado a uma cadeia de caracteres
	 */
	private String nomeDisciplina;
	
	/**
	 * O atributo horasDeEstudo refere-se a quantidade de horas destinadas aos estudo de determinada disciplina
	 */
	private int horasDeEstudo = 0;
	
	/**
	 * O array notas faz refer�ncia a um conjunto de notas que a Disciplina possui
	 */
	private double[] notas;
	
	/**
	 * O array pesos faz refer�ncia a um conjuntos de pesos para as respectivas notas
	 */
	private int[] pesos;
	
	
	/**
	 * Constr�i uma Disciplina a partir do seu respectivo nome.
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 */
	public Disciplina(String nomeDisciplina){
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		this.horasDeEstudo = 0;
	}
	
	/**
	 * Constr�i uma Disciplina a partir do seu nome e n�mero de notas, onde a partir
	 * do n�mero de notas, ser� criado um di�rio de n notas.
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 * @param num : O n�mero de notas que o di�rio de disciplina ter�, representado como um n�mero inteiro
	 */
	public Disciplina(String nomeDisciplina, int num){
		this(nomeDisciplina);
		this.notas = new double[num];
		this.horasDeEstudo = 0;
	}
	
	/**
	 * Constr�i uma Disciplina a partir do seu nome, n�mero de notas e array de pesos, onde a partir do n�mero de
	 * notas ser� criado um array de num notas de mesmo tamanho do array pesos.
	 * Inicialmente, as horas de estudos s�o inicializadas com 0 (zero).
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 * @param num : O n�mero de notas que o di�rio de disciplina ter�, representado como um n�mero inteiro
	 * @param pesos : O array de pesos que � passado
	 */
	public Disciplina(String nomeDisciplina, int num, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[num];
		this.horasDeEstudo = 0;
		this.pesos = pesos;
	}
	
	/**
	 * N�o possui retorno, apenas soma horas as horasDeEstudo
	 * 
	 * @param horas : representa o n�mero de horas que foram estudadas at� o momento. no formato de um n�mero inteiro
	 */
	public void cadastraHoras(int horas){
		horasDeEstudo = horas;
	}
	
	/**
	 * N�o possui retorno, apenas adiciona uma nota a uma posi��o do di�rio da Disciplina
	 * 
	 * @param nota : a posi��o no di�rio do Disciplina onde a nota deve ficar
	 * @param valorProva : representa o valor da nota que ser� adicionada ao array
	 */
	public void cadastraNota(int nota, double valorProva){
		this.notas[nota - 1] = valorProva;
	}
	
	/**
	 * Retorna um double que representa a m�dia da Disciplina. Calcula a m�dia sem o array de pesos ou com.
	 *  
	 * @return : a m�dia da Disciplina
	 */
	private double media(){
		double soma = 0;
		
		if(this.pesos != null) {
			int somaPesos = 0;
			for(int i = 0; i < this.notas.length; i++) {
				soma += notas[i] * pesos[i];
				somaPesos += pesos[i];
			}
			return soma / somaPesos;
		}
		else {
			for (double nota : notas) {
				soma += nota;
			}
			return soma / notas.length;
		}
	}
	
	/**
	 * Retorna um boolean, true para o caso de o aluno ser aprovado (m�dia maior ou igual a 7.0) ou false, 
	 * (caso contr�rio)
	 * 
	 * @return : se o aluno foi aprovado ou n�o na Disciplina
	 */
	public boolean aprovado(){
		if(media() >= 7.0)
			return true;
		return false;
	}
	
	/**
	 * Retorna a String que representa a Disciplina. A representa��o segue o formato:
	 * NOME_DISCIPLINA HORAS_DE_ESTUDO MEDIA_GERAL [DIARIO DE NOTAS]
	 * 
	 * @return : a representa��o em String de uma Disciplina
	 */
	public String toString(){
		return String.format("%s %d %.1f %s", nomeDisciplina, horasDeEstudo, media(), Arrays.toString(notas));
	}
	
	/**
	 * Retorna o nome da disciplina
	 * 
	 * @return : o nome da disciplina
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
}
