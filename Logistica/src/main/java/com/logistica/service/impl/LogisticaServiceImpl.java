package com.logistica.service.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.logistica.business.LogisticaBusiness;
import com.logistica.dto.MensagemDTO;
import com.logistica.dto.RotaRequestDTO;
import com.logistica.dto.RotaResponseDTO;
import com.logistica.exception.BusinessException;
import com.logistica.service.LogisticaService;
import com.logistica.util.ConstanteUtil;

@Path("/restwebservice")
public class LogisticaServiceImpl implements LogisticaService {

	@POST
	@Path("consultaRota")
	public String consultarRota(String json) {
		LogisticaBusiness logistica = new LogisticaBusiness();
		RotaResponseDTO response = new RotaResponseDTO();
		MensagemDTO mensagem = new MensagemDTO();
		RotaRequestDTO request = new RotaRequestDTO();
		Gson gson = new Gson();
		
		try {
			request = gson.fromJson(json,RotaRequestDTO.class);
			response = logistica.getBestRota(request);
			mensagem = montarMensagem(ConstanteUtil.COD_SUCESSO, ConstanteUtil.MSG_SUCESSO);
			
		} catch (BusinessException be) {
			mensagem = montarMensagem(ConstanteUtil.COD_ERRO, be.getMessage());
			
		} catch (JsonSyntaxException je) {
			mensagem = montarMensagem(ConstanteUtil.COD_JSON, je.getMessage());
			
		} catch (Exception e) {
			mensagem = montarMensagem(ConstanteUtil.COD_ERRO, e.getMessage());
		}
		
		response.setMensagem(mensagem);
		return gson.toJson(response);
	}

	private MensagemDTO montarMensagem(Integer codigo, String message) {
		MensagemDTO mensagem = new MensagemDTO();
		mensagem.setCodigoRetorno(codigo);
		mensagem.setMensagemRetorno(message);
		return mensagem;
	}
}
