package br.com.banco.model;

public class TransferenciaSaldo {

	private Double saldoTotal;

	private Double saldoPeriodo;

	public TransferenciaSaldo(Double saldoTotal, Double saldoPeriodo) {
		this.saldoTotal = saldoTotal;
		this.saldoPeriodo = saldoPeriodo;
	}

	public Double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Double getSaldoPeriodo() {
		return saldoPeriodo;
	}

	public void setSaldoPeriodo(Double saldoPeriodo) {
		this.saldoPeriodo = saldoPeriodo;
	}

}
