package lab2.paulo_junior;

/**
* Representa��o da Sa�de de um aluno matriculado na UFCG, do curso de Ci�ncia da Computa��o.
* Toda Sa�de possui uma sa�de f�sica e uma sa�de mental
* 
* @author Paulo Mendes da Silva Junior - 117210922
*/

public class Saude 
{
	/**
	 * Representa a sa�de f�sica de um aluno
	 */
	private String saudeFisica;
	
	/**
	 * Representa a sa�de mental de um aluno
	 */
	private String saudeMental;
	
	/**
	 * Um emoji que representa o estado de sa�de atual do aluno, dependendo da sa�de f�sica e mental
	 */
	private String emoji;
	
	
	/**
	 * Constr�i uma sa�de para um aluno rsrs. N�o possui argumentos
	 * Por padr�o, tanto a sa�de f�sica e a sa�de mental s�o inicializada com "boa" e o emoji � inicializado como feliz
	 */
	public Saude(){
		saudeFisica = "boa";
		saudeMental = "boa";
	}
	
	/**
	 * N�o possui valor de retorno. Apenas adiciona um emoji referente a �ltima sensa��o do aluno.
	 * @param valor : uma string com dois valores poss�veis
	 */
	public void definirEmoji(String valor) {
		emoji = valor;
	}
	
	/**
	 * N�o possui valor de retorno. Apenas altera o status da sa�de f�sica de um aluno
	 * 
	 * @param status : o novo status da sa�de f�sica de um aluno
	 */
	public void defineSaudeFisica(String status){
		saudeFisica = status;
		definirEmoji(null);
	}
	
	/**
	 * N�o possui valor de retorno. Apenas altera o status da sa�de mental de um aluno
	 * 
	 * @param status : o novo status da sa�de mental de um aluno
	 */
	public void defineSaudeMental(String status){
		saudeMental = status;
		definirEmoji(null);
	}
	
	/**
	 * Retorna a String que representa a Saude. a representa��o segue o formato:
	 * STATUS_SAUDE EMOJI (dependendo se a sa�de foi setada
	 * 
	 * @return : retorna a representa��o string do estado atual de sa�de
	 */
	public String getStatusGeral(){
		if(saudeFisica.equals("boa") && saudeMental.equals("boa")) {
			if(emoji != null)
				return "boa " + emoji;
			else
				return "boa";
		}
		else if(saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
			if(emoji != null)
				return "fraca " + emoji;
			else
				return "fraca";
		}
		else
			return "ok";
	}
}
