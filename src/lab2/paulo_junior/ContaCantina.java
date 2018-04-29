package lab2.paulo_junior;

import java.util.ArrayList;
import java.util.List;

/**
* Representa��o de um Conta de uma Cantina de um aluno matriculado na UFCG, do curso de Ci�ncia da Computa��o.
* Toda ContaCantina possui um nome, um d�bito e uma quantidade de itens que foram comprados
* 
* @author Paulo Mendes da Silva J�nior - 117210922
*/

public class ContaCantina 
{
	/**
	 * O nome da cantina � associado a uma cadeia de caracteres (String)
	 */
	private String nomeCantina;
	
	/**
	 * Refere-se ao d�bito que um aluno tem em uma cantina. representado como um valor inteiro
	 */
	private int debitoConta;
	
	/**
	 * Refere-se a quantidade de itens que foram comprados na cantina. representado por um valor inteiro
	 */
	private int qtdItens = 0;
	
	/**
	 * Refere-se aos detalhes das �ltimas cinco compras na cantina. representado por Strings
	 */
	private List<String> detalhes;
	
	
	/**
	 * Constr�i uma Conta na Cantina a partir do nome da cantina
	 * 
	 * @param nomeCantina : o nome da cantina representado por uma String
	 */
	public ContaCantina(String nomeCantina){
		this.nomeCantina = nomeCantina;
		this.detalhes = new ArrayList<String>();
	}
	
	/**
	 * N�o possui valor de retorno. Apenas cadastra uma compra, adicionando a quantidade de lanches que foram comprados
	 * e o valor da compra.
	 * 
	 * @param qtdLanches : representa a quantidade de lanches que foram comprados (valor inteiro)
	 * @param valorCentavos : representa o valor total da compra (valor inteiro)
	 */
	public void cadastrarLanche(int qtdLanches, int valorCentavos){
		this.debitoConta += valorCentavos;
		this.qtdItens += qtdLanches;
	}
	
	/**
	 * Sobrecarga do m�todo cadastrarLanche, com o acr�scimo dos detalhes da compra efetuada.
	 * 
	 * @param qtdLanches : representa a quantidade de lanches que foram comprados (valor inteiro)
	 * @param valorCentavos : representa o valor total da compra (valor inteiro)
	 * @param detalhes : informa��es sobre a compra (String)
	 */
	public void cadastrarLanche(int qtdLanches, int valorCentavos, String detalhes) {
		this.debitoConta += valorCentavos;
		this.qtdItens += qtdLanches;
		this.detalhes.add(detalhes);
	}
	
	/**
	 * N�o possui valor de retorno. Apenas recebe um valor que ser� descontada na conta de um aluno.
	 * Espera-se que esse valor seja menor ou igual ao d�bito na cantina
	 * 
	 * @param qtdCentavos : representa a quantidade que ser� descontada no d�bito total (valor inteiro)
	 */
	public void pagaConta(int qtdCentavos){
		this.debitoConta -= qtdCentavos;
	}
	
	/**
	 * M�todo n�o possui retorno
	 * 
	 * Mostra o registro das �ltimas cinco compras na cantina
	 */
	public void listarDetalhes() {
		System.out.println("***REGISTRO DE COMPRAS***");
		for (String detalhe : this.detalhes) {
			System.out.println("- " + detalhe);
		}
	}
	
	/**
	 * Retorna a String que representa a ContaCantina. a representa��o segue o formato
	 * NOME_CANTINA QUANTIDADE_ITENS DEBITO_CONTA
	 * 
	 * @return : A representa��o String de um objeto ContaCantina
	 */
	public String toString(){
		return String.format("%s %d %d", nomeCantina, qtdItens, debitoConta);
	}
	
	/**
	 * Retorna o nome da Cantina
	 * 
	 * @return : nome da cantina
	 */
	public String getNomeCantina() {
		return nomeCantina;
	}
	
}
