package Negocios;

import java.sql.Date;

public class Matricula {
	private Date data;
	private Double valorPago;
	
	public Matricula() {
		
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	
}
