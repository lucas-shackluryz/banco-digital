package br.com.dio.model;

public abstract class Conta implements IConta {
	
	protected static final int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		if(valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("N�o foi poss�vel efetuar a opera��o. Saldo Insuficiente.");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("N�o foi poss�vel efetuar a opera��o. Saldo Insuficiente.");
		}
	}

	protected void imprimirDadosConta() {
		System.out.println("Titular: " + this.cliente.getNome());
		System.out.println(String.format("Ag�ncia: %d", this.agencia));
		System.out.println(String.format("N�mero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	

}
