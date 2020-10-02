package com.priceshoes.rest.applications.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import com.priceshoes.rest.applications.transfer.TransferService;

public class TareasProgramadas 
{
	private static Logger log = Logger.getLogger(TareasProgramadas.class);
	
	@Autowired private TransferService transferService;
	
	/** cron.properties */
	@Value("${t1.desc}")		private String 	t1Desc;
	@Value("${t1.prefix}")		private String	t1Prefix;
	@Value("${t1.enabled}")		private boolean	t1Enabled;
	
	@Scheduled(cron = "${t1.cron}")
	public void tarea1() 
	{
		boolean taskEnabled 	= t1Enabled;
		String taskDesc 		= t1Desc;
		String prefix 			= t1Prefix;
		
		if(taskEnabled )
		{
			log.info(prefix+" | ** TAREA PROGRAMADA: " + taskDesc);
			//---------------------------------
			transferService.runTaskTransferirSaldosPendientes();
			//---------------------------------
			log.info(prefix+" | ** FIN DE TAREA PROGRAMADA: "+taskDesc);
		}	
		else
		{
			log.info(prefix+" | ** TAREA INACTIVA: " + taskDesc);
		}	
	}
}
