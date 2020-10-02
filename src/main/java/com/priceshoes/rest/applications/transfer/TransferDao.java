package com.priceshoes.rest.applications.transfer;

import java.util.List;

import com.priceshoes.rest.applications.entity.PsPedtmkInfMppagoDetInfo;

public interface TransferDao {

	List<PsPedtmkInfMppagoDetInfo> getSaldosPorTransferir();

	List<PsPedtmkInfMppagoDetInfo> getSaldosPorTransferir(Long sucursal, Long pedido);

}
