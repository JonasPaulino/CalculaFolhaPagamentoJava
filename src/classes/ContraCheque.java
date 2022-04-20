package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class ContraCheque {
	public String ano;
	public String mes;
	public BigDecimal valorLiquido;
	public BigDecimal valorBruto;
	public BigDecimal valorProventos;
	public BigDecimal valorDesconto;
	public List<Lancamento> lancamentos = new ArrayList<>();
	
	public void SomaValores() {
		this.valorLiquido 	= BigDecimal.ZERO;
		this.valorBruto 	= BigDecimal.ZERO;
		this.valorProventos = BigDecimal.ZERO;
		this.valorDesconto 	= BigDecimal.ZERO;
		
		//faz uma varredura na quantidade de lançamentos
		for(int i = 0; i< lancamentos.size(); i++) {
			//checa se o lançamento é do tipo provento
			if(lancamentos.get(i).tipo == Main.PROVENTO) {
				this.valorProventos = this.valorProventos.add(lancamentos.get(i).valor);
				this.valorBruto 	= this.valorBruto.add(lancamentos.get(i).valor);
				this.valorLiquido   = this.valorLiquido.add(lancamentos.get(i).valor);
			} else { //Descontos
				this.valorDesconto 	= this.valorDesconto.add(lancamentos.get(i).valor);
				this.valorLiquido	= this.valorLiquido.subtract(lancamentos.get(i).valor);
			}
			
		}
	}

}
