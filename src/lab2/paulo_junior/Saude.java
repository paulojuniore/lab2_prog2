package lab2.paulo_junior;

/**
* Representação da Saúde de um aluno matriculado na UFCG, do curso de Ciência da Computação.
* Toda Saúde possui uma saúde física e uma saúde mental
* 
* @author Paulo Mendes da Silva Junior - 117210922
*/

public class Saude 
{
	/**
	 * Representa a saúde física de um aluno
	 */
	private String saudeFisica;
	
	/**
	 * Representa a saúde mental de um aluno
	 */
	private String saudeMental;
	
	/**
	 * Um emoji que representa o estado de saúde atual do aluno, dependendo da saúde física e mental
	 */
	private String emoji;
	
	
	/**
	 * Constrói uma saúde para um aluno rsrs. Não possui argumentos
	 * Por padrão, tanto a saúde física e a saúde mental são inicializada com "boa" e o emoji é inicializado como feliz
	 */
	public Saude(){
		saudeFisica = "boa";
		saudeMental = "boa";
	}
	
	/**
	 * Não possui valor de retorno. Apenas adiciona um emoji referente a última sensação do aluno.
	 * @param valor : uma string com dois valores possíveis
	 */
	public void definirEmoji(String valor) {
		emoji = valor;
	}
	
	/**
	 * Não possui valor de retorno. Apenas altera o status da saúde física de um aluno
	 * 
	 * @param status : o novo status da saúde física de um aluno
	 */
	public void defineSaudeFisica(String status){
		saudeFisica = status;
		definirEmoji(null);
	}
	
	/**
	 * Não possui valor de retorno. Apenas altera o status da saúde mental de um aluno
	 * 
	 * @param status : o novo status da saúde mental de um aluno
	 */
	public void defineSaudeMental(String status){
		saudeMental = status;
		definirEmoji(null);
	}
	
	/**
	 * Retorna a String que representa a Saude. a representação segue o formato:
	 * STATUS_SAUDE EMOJI (dependendo se a saúde foi setada
	 * 
	 * @return : retorna a representação string do estado atual de saúde
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
