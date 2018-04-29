package lab2.paulo_junior;

/**
* Representação de uma Conta de Laboratório de um aluno matriculado na UFCG, do curso de Ciência da Computação.
* Toda Conta de Laboratório possui um nome do laboratório, espaço ocupado (Mb) e Cota máxima.
* 
* @author Paulo Mendes da Silva Junior - 117210922
*/

public class ContaLaboratorio 
{
	
	/**
	 * Representa o nome do laboratório
	 */
	private String nomeLab;
	
	/**
	 * Representa a quantidade memória que foi utilizada
	 */
	private int espacoOcupado = 0;
	
	/**
	 * Representa a cota máxima de memória que o aluno pode usufruir
	 */
	private int cota = 2000;
	
	/**
	 * Constrói uma conta no laboratório a partir do nome do laboratório
	 * 
	 * @param nomeLab : refere-se ao nome do laboratório (String)
	 */
	public ContaLaboratorio(String nomeLab){
		this.nomeLab = nomeLab;
	}
	
	/**
	 * Constrói uma conta no laboratório a partir do nome do laboratório e da cota
	 * 
	 * @param nomeLab : refere-se ao nome do laboratório (String)
	 * @param cota : Representa a cota máxima de memória que o aluno pode usufruir
	 */
	public ContaLaboratorio(String nomeLab, int cota){
		this.nomeLab = nomeLab;
		this.cota = cota;
	}
	
	/**
	 * Não possui valor de retorno. Apenas consome uma quantidade de espaço da conta. Supõe-se que esse valor em Mb seja menor que a cota máxima.
	 * 
	 * @param mBytes : representa a quantidade de memória que será consumida naquele momento
	 */
	public void consomeEspaco(int mBytes){
		this.espacoOcupado += mBytes;
	}
	
	/**
	 * Não possui valor de retorno. Apenas libera uma quantidade de espaço da conta. Supõe-se que esse valor em Mb seja maior que o espaco ocupado.
	 * 
	 * @param mBytes : representa a quantidade de memória que será liberada naquele momento
	 */
	public void liberaEspaco(int mBytes){
		this.espacoOcupado -= mBytes;
	}
	
	/**
	 * Retorna um boolean, true, se a cota máxima for atingida ou ultrapassada (2000), ou false (caso contrário)
	 * 
	 * @return se a cota máxima foi ou não atingida/ultrapassada
	 */
	public boolean atingiuCota(){
		if(espacoOcupado >= cota)
			return true;
		return false;
	}
	
	/**
	 * Retorna a String que representa a ContaLaboratorio. a representação segue o formato
	 * NOME_LABORATORIO ESPACO_OCUPADO/COTA_MAXIMA
	 * 
	 * @return : A representação String de um objeto ContaLaboratorio
	 */
	public String toString(){
		return String.format("%s %d/%d", nomeLab, espacoOcupado, cota);
	}
	
	/**
	 * Retorna o nome do laboratório
	 * 
	 * @return : nome do laboratório
	 */
	public String getNomeLab() {
		return nomeLab;
	}
}
