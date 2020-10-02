package com.priceshoes.rest.applications.transfer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.priceshoes.rest.applications.entity.PsPedtmkInfMppagoDetInfo;

@Service
public class TransferServiceImpl implements TransferService
{
	private static Logger log = Logger.getLogger(TransferServiceImpl.class);
	
	@Autowired private TransferDao dao;
	@Autowired private Environment env;
	
	@Override
	public void runTaskTransferirSaldosPendientes() 
	{
		List<PsPedtmkInfMppagoDetInfo> pendientes = dao.getSaldosPorTransferir();
		for(PsPedtmkInfMppagoDetInfo row: pendientes)
		{
			log.info("Row:"+new Gson().toJson(row));
			transferirSaldo(row);
		}
	}
	
	private void transferirSaldo(PsPedtmkInfMppagoDetInfo row)
	{
		String sender = env.getProperty("price.sucursal");
		CloseableHttpClient clientPost = null;
		try{
			
			String url = env.getProperty("web.service.transfer");
			String endPoint ="transfers/transferirSaldo/";

			clientPost = HttpClientBuilder.create().build();
			log.debug("Servicio "+url+endPoint);
			
			TransferRequest request = new TransferRequest();
			request.setSender(sender);
			request.setDetInfo(row);
			
			HttpPost postRequest = new HttpPost(url+endPoint);
			postRequest.addHeader("accept", "application/json");
			postRequest.addHeader("Content-type", "application/json");
			postRequest.setEntity(new StringEntity(new Gson().toJson(request)));
			
			CloseableHttpResponse response = clientPost.execute(postRequest);
			log.info("-----------------------------------------------------");
			log.info(url+endPoint);
			log.debug(response.getStatusLine().getStatusCode());
			log.info(response.getStatusLine());
			log.info("----------------------------------------");
			
			byte[] buffer = new byte[1024];
			StringBuilder chunk = new StringBuilder();
			if (response.getEntity() != null)
			{
				InputStream inputStream = response.getEntity().getContent();
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				while ((bytesRead = bis.read(buffer)) != -1)
				{
					chunk.append( new String(buffer, 0, bytesRead));
				}
				
				TransferResponse transferResponse = new Gson().fromJson(chunk.toString(), TransferResponse.class);
				log.info(new Gson().toJson(transferResponse));
			}
			
		} catch (ClientProtocolException e){log.error(e.getMessage(),e); } 
		  catch (IOException e){			log.error(e.getMessage(),e); }
		  finally {	if (clientPost!=null)try{clientPost.close();} catch (IOException e){e.printStackTrace();}	}
	}

	@Override
	@Async("jobExecutor")
	public void transferirSaldo(Long sucursal, Long pedido) 
	{
		try
		{
			List<PsPedtmkInfMppagoDetInfo> saldos = dao.getSaldosPorTransferir(sucursal,pedido);
			if(saldos.size()>0)
			{	
				log.info("Transfiriendo saldos");
				for(PsPedtmkInfMppagoDetInfo det:saldos)
				{
					log.info("Det: "+new Gson().toJson(det));
					transferirSaldo(det);
				}
				log.info("Fin transferencia saldos");
			}
		}catch (Exception e) 
		{
			log.error(e.getMessage());
		}
	}
}
