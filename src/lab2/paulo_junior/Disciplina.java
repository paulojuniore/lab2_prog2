package lab2.paulo_junior;

import java.util.Arrays;

/**
* Representação de uma Disciplina de um aluno matriculado na UFCG, do curso de Ciência da Computação.
* Toda disciplina possui um nome, uma quantidade de horas associadas e várias notas.
* 
* @author Paulo Mendes da Silva Júnior - 117210922
*/

public class Disciplina 
{
	/**
	 * Nome da Disciplina é associado a uma cadeia de caracteres
	 */
	private String nomeDisciplina;
	
	/**
	 * O atributo horasDeEstudo refere-se a quantidade de horas destinadas aos estudo de determinada disciplina
	 */
	private int horasDeEstudo = 0;
	
	/**
	 * O array notas faz referência a um conjunto de notas que a Disciplina possui
	 */
	private double[] notas;
	
	/**
	 * O array pesos faz referência a um conjuntos de pesos para as respectivas notas
	 */
	private int[] pesos;
	
	
	/**
	 * Constrói uma Disciplina a partir do seu respectivo nome.
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 */
	public Disciplina(String nomeDisciplina){
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
		this.horasDeEstudo = 0;
	}
	
	/**
	 * Constrói uma Disciplina a partir do seu nome e número de notas, onde a partir
	 * do número de notas, será criado um diário de n notas.
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 * @param num : O número de notas que o diário de disciplina terá, representado como um número inteiro
	 */
	public Disciplina(String nomeDisciplina, int num){
		this(nomeDisciplina);
		this.notas = new double[num];
		this.horasDeEstudo = 0;
	}
	
	/**
	 * Constrói uma Disciplina a partir do seu nome, número de notas e array de pesos, onde a partir do número de
	 * notas será criado um array de num notas de mesmo tamanho do array pesos.
	 * Inicialmente, as horas de estudos são inicializadas com 0 (zero).
	 * 
	 * @param nomeDisciplina : O nome da disciplina representado como uma cadeia de caracteres
	 * @param num : O número de notas que o diário de disciplina terá, representado como um número inteiro
	 * @param pesos : O array de pesos que é passado
	 */
	public Disciplina(String nomeDisciplina, int num, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[num];
		this.horasDeEstudo = 0;
		this.pesos = pesos;
	}
	
	/**
	 * Não possui retorno, apenas soma horas as horasDeEstudo
	 * 
	 * @param horas : representa o número de horas que foram estudadas até o momento. no formato de um número inteiro
	 */
	public void cadastraHoras(int horas){
		horasDeEstudo = horas;
	}
	
	/**
	 * Não possui retorno, apenas adiciona uma nota a uma posição do diário da Disciplina
	 * 
	 * @param nota : a posição no diário do Disciplina onde a nota deve ficar
	 * @param valorProva : representa o valor da nota que será adicionada ao array
	 */
	public void cadastraNota(int nota, double valorProva){
		this.notas[nota - 1] = valorProva;
	}
	
	/**
	 * Retorna um double que representa a média da Disciplina. Calcula a média sem o array de pesos ou com.
	 *  
	 * @return : a média da Disciplina
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
	 * Retorna um boolean, true para o caso de o aluno ser aprovado (média maior ou igual a 7.0) ou false, 
	 * (caso contrário)
	 * 
	 * @return : se o aluno foi aprovado ou não na Disciplina
	 */
	public boolean aprovado(){
		if(media() >= 7.0)
			return true;
		return false;
	}
	
	/**
	 * Retorna a String que representa a Disciplina. A representação segue o formato:
	 * NOME_DISCIPLINA HORAS_DE_ESTUDO MEDIA_GERAL [DIARIO DE NOTAS]
	 * 
	 * @return : a representação em String de uma Disciplina
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
