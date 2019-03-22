package br.com.ccee.entity;

import java.math.BigDecimal;

public class Disccount {
	
	private int id;
	private int idEmployee;
	private BigDecimal disccountValue;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public BigDecimal getDisccountValue() {
		return disccountValue;
	}

	public void setDisccountValue(BigDecimal disccountValue) {
		this.disccountValue = disccountValue;
	}

}
