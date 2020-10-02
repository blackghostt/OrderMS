package com.priceshoes.rest.applications.transfer;

public interface TransferService 
{
	void runTaskTransferirSaldosPendientes();

	void transferirSaldo(Long sucursal, Long pedido);

}
