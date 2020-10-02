package com.priceshoes.rest.applications.transfer;

import com.priceshoes.rest.applications.entity.PsPedtmkInfMppagoDetInfo;

public class TransferRequest 
{
	private String 						sender;
	private PsPedtmkInfMppagoDetInfo	detInfo;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public PsPedtmkInfMppagoDetInfo getDetInfo() {
		return detInfo;
	}
	public void setDetInfo(PsPedtmkInfMppagoDetInfo detInfo) {
		this.detInfo = detInfo;
	}
}
