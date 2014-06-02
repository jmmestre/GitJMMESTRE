package com.logistica.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.logistica.dto.RotaRequestDTO;
import com.logistica.dto.RotaResponseDTO;

@ManagedBean
@SessionScoped
public class LogisticaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private RotaRequestDTO request = new RotaRequestDTO();
	
	private RotaResponseDTO response = new RotaResponseDTO();
	
	public String consultarRota() {
		
		Gson gson = new Gson();
		DefaultHttpClient httpClient = new DefaultHttpClient();
        ResponseHandler <String> resonseHandler = new BasicResponseHandler();
                
        HttpPost postMethod = new HttpPost("http://localhost:8585/Logistica/rest/restwebservice/consultaRota");
        
        String responseXml = null;
        
        postMethod.setHeader( "Content-Type", "application/json" );
        
		try {
			postMethod.setEntity(new ByteArrayEntity(gson.toJson(request).toString().getBytes("UTF8")));
			responseXml = httpClient.execute(postMethod, resonseHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		setResponse(gson.fromJson(responseXml, RotaResponseDTO.class));
		
		return "menorRota";
		
	}

	public RotaRequestDTO getRota() {
		return request;
	}

	public void setRota(RotaRequestDTO rota) {
		this.request = rota;
	}

	public RotaResponseDTO getResponse() {
		return response;
	}

	public void setResponse(RotaResponseDTO response) {
		this.response = response;
	}

}