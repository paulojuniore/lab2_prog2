package lab2.paulo_junior;

/**
* Representa��o de uma Conta de Laborat�rio de um aluno matriculado na UFCG, do curso de Ci�ncia da Computa��o.
* Toda Conta de Laborat�rio possui um nome do laborat�rio, espa�o ocupado (Mb) e Cota m�xima.
* 
* @author Paulo Mendes da Silva Junior - 117210922
*/

public class ContaLaboratorio 
{
	
	/**
	 * Representa o nome do laborat�rio
	 */
	private String nomeLab;
	
	/**
	 * Representa a quantidade mem�ria que foi utilizada
	 */
	private int espacoOcupado = 0;
	
	/**
	 * Representa a cota m�xima de mem�ria que o aluno pode usufruir
	 */
	private int cota = 2000;
	
	/**
	 * Constr�i uma conta no laborat�rio a partir do nome do laborat�rio
	 * 
	 * @param nomeLab : refere-se ao nome do laborat�rio (String)
	 */
	public ContaLaboratorio(String nomeLab){
		this.nomeLab = nomeLab;
	}
	
	/**
	 * Constr�i uma conta no laborat�rio a partir do nome do laborat�rio e da cota
	 * 
	 * @param nomeLab : refere-se ao nome do laborat�rio (String)
	 * @param cota : Representa a cota m�xima de mem�ria que o aluno pode usufruir
	 */
	public ContaLaboratorio(String nomeLab, int cota){
		this.nomeLab = nomeLab;
		this.cota = cota;
	}
	
	/**
	 * N�o possui valor de retorno. Apenas consome uma quantidade de espa�o da conta. Sup�e-se que esse valor em Mb seja menor que a cota m�xima.
	 * 
	 * @param mBytes : representa a quantidade de mem�ria que ser� consumida naquele momento
	 */
	public void consomeEspaco(int mBytes){
		this.espacoOcupado += mBytes;
	}
	
	/**
	 * N�o possui valor de retorno. Apenas libera uma quantidade de espa�o da conta. Sup�e-se que esse valor em Mb seja maior que o espaco ocupado.
	 * 
	 * @param mBytes : representa a quantidade de mem�ria que ser� liberada naquele momento
	 */
	public void liberaEspaco(int mBytes){
		this.espacoOcupado -= mBytes;
	}
	
	/**
	 * Retorna um boolean, true, se a cota m�xima for atingida ou ultrapassada (2000), ou false (caso contr�rio)
	 * 
	 * @return se a cota m�xima foi ou n�o atingida/ultrapassada
	 */
	public boolean atingiuCota(){
		if(espacoOcupado >= cota)
			return true;
		return false;
	}
	
	/**
	 * Retorna a String que representa a ContaLaboratorio. a representa��o segue o formato
	 * NOME_LABORATORIO ESPACO_OCUPADO/COTA_MAXIMA
	 * 
	 * @return : A representa��o String de um objeto ContaLaboratorio
	 */
	public String toString(){
		return String.format("%s %d/%d", nomeLab, espacoOcupado, cota);
	}
	
	/**
	 * Retorna o nome do laborat�rio
	 * 
	 * @return : nome do laborat�rio
	 */
	public String getNomeLab() {
		return nomeLab;
	}
}
