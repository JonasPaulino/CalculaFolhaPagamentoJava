package main;

import java.math.BigDecimal;
import classes.ContraCheque;       
import classes.FolhaPagamento;
import classes.Lancamento;
import classes.Pessoa;

public class Main {
	//Constante para gravar os tipos de lançamentos
	public static final String PROVENTO = "Provento";
	public static final String DESCONTO = "Desconto";	
	
	public static void main(String[] args) {
		
		//LANÇAMENTOS
		Lancamento lancamento1 = new Lancamento();
		Lancamento lancamento2 = new Lancamento();
		Lancamento lancamento3 = new Lancamento();
		Lancamento lancamento4 = new Lancamento();
		Lancamento lancamento5 = new Lancamento();	
		Lancamento lancamento6 = new Lancamento();	
		
		lancamento1.tipo = PROVENTO; 
		lancamento1.descricao = "Salario mês"; 
		lancamento1.valor = new BigDecimal(1500.00);

		lancamento5.tipo = PROVENTO; 
		lancamento5.descricao = "Horas extras"; 
		lancamento5.valor = new BigDecimal(120.00);
		
		lancamento2.tipo = DESCONTO; 
		lancamento2.descricao = "INSS" ;
		lancamento2.valor = new BigDecimal(200.00);
		
		lancamento3.tipo  = PROVENTO; 
		lancamento3.descricao = "Salario mês"; 
		lancamento3.valor = new BigDecimal(2500.00);

		lancamento4.tipo = DESCONTO; 
		lancamento4.descricao = "INSS"; 
		lancamento4.valor = new BigDecimal(300.00);
		
		lancamento6.tipo = DESCONTO; 
		lancamento6.descricao = "Falta 24hs"; 
		lancamento6.valor = new BigDecimal(100.00);
		//FIM LANÇAMENTO
		
		//CONTRA-CHEQUE
		ContraCheque contraCheque1 = new ContraCheque();
		ContraCheque contraCheque2 = new ContraCheque();
		ContraCheque contraCheque3 = new ContraCheque();
		ContraCheque contraChequeQuinze = new ContraCheque();
		
		contraCheque1.ano = "2022";
		contraCheque1.mes = "Janeiro"; 
		contraCheque1.lancamentos.add(lancamento1); 
		contraCheque1.lancamentos.add(lancamento2);
		contraCheque1.lancamentos.add(lancamento5);
		
		contraCheque2.ano = "2022";
		contraCheque2.mes = "Janeiro"; 
		contraCheque2.lancamentos.add(lancamento3);
		contraCheque2.lancamentos.add(lancamento4);
		contraCheque2.lancamentos.add(lancamento6);
		
		contraChequeQuinze.ano = "2022";
		contraChequeQuinze.mes = "Fevereiro"; 
		contraChequeQuinze.lancamentos.add(lancamento1);
		
		
		contraCheque3.ano = "2022";
		contraCheque3.mes = "Fevereiro"; 
		contraCheque3.lancamentos.add(lancamento3);
		contraCheque3.lancamentos.add(lancamento4);
		//FIM LANÇAMENTO CONTRA-CHEQUE
		
		//PESSOA
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		
		pessoa1.nome = "Jonas Paulino";
		pessoa1.matricula = "01402046";
		pessoa1.contraCheques.add(contraCheque1); 
		

		pessoa2.nome = "Professor POO";
		pessoa2.matricula = "10101010";
		pessoa2.contraCheques.add(contraCheque2);
		pessoa2.contraCheques.add(contraCheque3);
		pessoa2.contraCheques.add(contraChequeQuinze);
		//FIM PESSOA
		
		FolhaPagamento folhaPagamento = new FolhaPagamento();
		
		folhaPagamento.pessoas.add(pessoa1);
		folhaPagamento.pessoas.add(pessoa2);
		folhaPagamento.CalcularFolha("Janeiro","2022");
	}
	
	
	
}
