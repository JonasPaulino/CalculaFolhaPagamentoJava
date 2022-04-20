package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import main.Main;

public class FolhaPagamento {
	public String ano;
	public String mes;
	public BigDecimal valorTotal;
	public List<Pessoa> pessoas =  new ArrayList<>();
	
	public void CalcularFolha(String mes, String ano) {
		this.valorTotal = BigDecimal.ZERO;
		this.mes		= mes;
		this.ano		= ano;
		BigDecimal valProv = BigDecimal.ZERO;
		BigDecimal valDesc = BigDecimal.ZERO;
		BigDecimal valLiqu = BigDecimal.ZERO;
		
		//monta cabeçalho do relatório
		System.out.printf("##################################################################%n");
		System.out.printf("# Folha de pagamento referente ao Mês/Ano :         %s/%s #%n",this.mes,this.ano);
		System.out.printf("##################################################################%n");
		System.out.printf("NOME                  PROVENTO        DESCONTO         LIQUIDO%n");
		System.out.printf("------------------------------------------------------------------%n");		
		
		//faz uma varredura na quantidade de pessoas
		for(int i = 0; i< pessoas.size(); i++) {
			//zera o valor das variaveis para uma nova pessoa
			valProv = BigDecimal.ZERO;
			valDesc = BigDecimal.ZERO;
			valLiqu = BigDecimal.ZERO;
			
			//varre todos os contra cheques de cada pessoa
			for(int j = 0; j< pessoas.get(i).contraCheques.size();j++) {			
				if(mes == pessoas.get(i).contraCheques.get(j).mes &&
				   ano == pessoas.get(i).contraCheques.get(j).ano ) {
					
					pessoas.get(i).contraCheques.get(j).SomaValores();
					this.valorTotal = this.valorTotal.add(pessoas.get(i).contraCheques.get(j).valorLiquido);
					
					//armazena valores local para utilizar na impressão por pessoa
					valProv = valProv.add(pessoas.get(i).contraCheques.get(j).valorProventos);
					valDesc = valDesc.add(pessoas.get(i).contraCheques.get(j).valorDesconto);
					valLiqu = valLiqu.add(pessoas.get(i).contraCheques.get(j).valorLiquido);
				}
			}		
		
			//Imprime detalhamento das pessoas
			System.out.printf("%s         %.2f         %.2f           %.2f %n",
								pessoas.get(i).nome,
								valProv,
								valDesc,
								valLiqu);
		}
		System.out.printf("%n%n##################################################################%n");
		System.out.printf("# Valor Total da folha ---------------------------> R$ %.2f   #%n",this.valorTotal);
		System.out.printf("##################################################################%n");		

	}

}
