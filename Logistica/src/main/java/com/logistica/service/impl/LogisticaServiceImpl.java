package com.logistica.service.impl;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.logistica.business.LogisticaBusiness;
import com.logistica.dto.MensagemDTO;
import com.logistica.dto.RotaRequestDTO;
import com.logistica.dto.RotaResponseDTO;
import com.logistica.exception.BusinessException;
import com.logistica.service.LogisticaService;
import com.logistica.util.ConstanteUtil;

@Path("/restwebservice")
public class LogisticaServiceImpl implements LogisticaService {

	@GET
	@Path("consultaRota")
	@Produces("application/xml")
	public RotaResponseDTO consultarRota(@QueryParam("origem") Integer origem, 
			                        @QueryParam("destino") Integer destino, 
			                        @QueryParam("autonomia") Integer autonomia,
			                        @QueryParam("valorCombustivel") Double valorCombustivel) {
		
		RotaRequestDTO request = new RotaRequestDTO();
		request.setIdOrigem(origem);
		request.setIdDestino(destino);
		request.setAutonomia(autonomia);
		request.setValorCombustivel(valorCombustivel);
		
		LogisticaBusiness logistica = new LogisticaBusiness();
		RotaResponseDTO response = new RotaResponseDTO();
		MensagemDTO mensagem = new MensagemDTO();
		
		try {
			
			response = logistica.getBestRota(request);
			
			response.setMenorCusto(calcularCusto(response.getMenorDistancia(), autonomia, valorCombustivel));
			mensagem.setCodigoRetorno(ConstanteUtil.COD_SUCESSO);
			mensagem.setMensagemRetorno(ConstanteUtil.MSG_SUCESSO);
			
		} catch (BusinessException e) {
			mensagem.setCodigoRetorno(ConstanteUtil.COD_ERRO);
			mensagem.setMensagemRetorno(e.getMessage());
		} catch (Exception e) {
			mensagem.setCodigoRetorno(ConstanteUtil.COD_ERRO);
			mensagem.setMensagemRetorno(e.getMessage());
		}
		
		response.setMensagem(mensagem);
		return response;
	}
	
	private BigDecimal calcularCusto(Integer menorDistancia, Integer autonomia, Double valorCombustivel) {
		return new BigDecimal(menorDistancia / autonomia * valorCombustivel);
	}

}
