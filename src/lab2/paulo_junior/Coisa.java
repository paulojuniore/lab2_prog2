package lab2.paulo_junior;

/**
* Classe de testes para as outras classes criadas (ContaLaboratorio, ContaCantina, Disciplina, Saude e Aluno).
* 
* @author Paulo Mendes da Silva Júnior - 117210922
*/

public class Coisa 
{

	public static void main(String[] args) 
	{
		/**
		 * Testes para a parte obrigatória do projeto
		 */
		ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");
		contaLCC2.consomeEspaco(1999);
		System.out.println(contaLCC2.atingiuCota());
		contaLCC2.consomeEspaco(2);
		System.out.println(contaLCC2.atingiuCota());
		contaLCC2.liberaEspaco(1);
		System.out.println(contaLCC2.atingiuCota()); 
		contaLCC2.liberaEspaco(1);
		System.out.println(contaLCC2.atingiuCota());
		System.out.println(contaLCC2.toString());
		
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());     
        
		ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");            
        mulherDoBolo.cadastrarLanche(2, 500, "Bolinho Gostoso");
        mulherDoBolo.cadastrarLanche(1, 500, "Tapioca de Frango");
        mulherDoBolo.cadastrarLanche(3, 1000, "Cachorro Quente");
        mulherDoBolo.pagaConta(200);
        System.out.println(mulherDoBolo.toString());
        mulherDoBolo.listarDetalhes();
        
        Saude saude = new Saude();
        saude.definirEmoji(":)");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("boa");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        
        System.out.println("\n*****BÔNUS*****\n");
        
        /**
         * Testes para o bônus do projeto
         */      
        int arrayPesos[] = {2, 3, 4, 5, 7};
        Disciplina prog3 = new Disciplina("PROGRAMACAO 3", 5, arrayPesos);
        prog3.cadastraNota(1, 5.0);
        prog3.cadastraNota(2, 3.0);
        prog3.cadastraNota(3, 6.0);
        prog3.cadastraNota(4, 8.0);
        prog3.cadastraNota(5, 9.0);
        System.out.println(prog3.aprovado());
        System.out.println(prog3.toString());
          
        Aluno paulo = new Aluno();
        paulo.cadastraLaboratorio("LCC 2", 2000);
        paulo.cadastraLaboratorio("LCC 3", 3000);
        paulo.consomeEspaco("LCC 2", 2500);
        paulo.consomeEspaco("LCC 3", 2500);
        System.out.println(paulo.atingiuCota("LCC 2"));
        System.out.println(paulo.laboratoriosToString("LCC 2"));
        System.out.println(paulo.laboratoriosToString("LCC 3"));
        
        
        int pesos[] = {8, 2, 3, 4, 5, 6};
        paulo.cadastraDisciplina("ESTRUTURAS DE DADOS", 6, pesos);
        paulo.cadastraDisciplina("PROJETO DE SOFTWARE", 4, pesos);
        paulo.cadastraHoras("ESTRUTURAS DE DADOS", 4);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 1, 9.0);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 2, 9.0);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 3, 9.0);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 4, 9.0);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 5, 9.0);
        paulo.cadastraNota("ESTRUTURAS DE DADOS", 6, 9.0);
        System.out.println(paulo.disciplinaToString("ESTRUTURAS DE DADOS"));
        System.out.println(paulo.disciplinaToString("PROJETO DE SOFTWARE"));
        System.out.println("Aprovado? " + paulo.aprovado("ESTRUTURAS DE DADOS"));
        
        paulo.cadastraCantina("Lanchonete do Seu Olavo");
        paulo.cadastraLanche("Lanchonete do Seu Olavo", 8, 100);
        paulo.cadastraLanche("Lanchonete do Seu Olavo", 10, 39);
        paulo.pagarConta("Lanchonete do Seu Olavo", 20);
        paulo.cadastraCantina("Lanchonete do Veí");
        System.out.println(paulo.cantinaToString("Lanchonete do Seu Olavo"));
        System.out.println(paulo.cantinaToString("Lanchonete do Veí"));
        
        Aluno samuel = new Aluno();
        samuel.cadastraCantina("Lanchonete do veí");
        samuel.cadastraLanche("Lanchonete do veí", 3, 100);
        System.out.println(samuel.cantinaToString("Lanchonete do veí"));
        
        paulo.defineSaudeFisica("boa");
        paulo.defineSaudeFisica("boa");
        System.out.println(paulo.getStatusGeral());
        
        samuel.defineSaudeFisica("fraca");
        samuel.defineSaudeMental("fraca");
        System.out.println(samuel.getStatusGeral());
	}

}
