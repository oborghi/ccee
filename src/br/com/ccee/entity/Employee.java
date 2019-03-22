package br.com.ccee.entity;

import java.math.BigDecimal;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private BigDecimal grossSalary;
	private List<Disccount> disccounts;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getGrossSalary() {
		return grossSalary;
	}


	public void setGrossSalary(BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	public BigDecimal getLiquidSalary() {
		if(this.disccounts == null || this.disccounts.size() == 0) {
			return this.grossSalary == null ? BigDecimal.ZERO : this.grossSalary;
		} else {
			BigDecimal totalDisccounts = BigDecimal.ZERO;
			BigDecimal liquidSalary = BigDecimal.ZERO;
			for(Disccount disccount : this.disccounts) {
				totalDisccounts.add(disccount.getDisccountValue() == null ? BigDecimal.ZERO : disccount.getDisccountValue());
			}
			liquidSalary = liquidSalary.add(this.grossSalary == null ? BigDecimal.ZERO : this.grossSalary);
			liquidSalary = liquidSalary.subtract(totalDisccounts);
			
			return liquidSalary;
		}
	}

	public List<Disccount> getDisccounts() {
		return disccounts;
	}

	public void setDisccounts(List<Disccount> disccounts) {
		this.disccounts = disccounts;
	}
}
