package com.cidadao.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsultaViaCepClientFallback implements ConsultaViaCepClient {

    @Override
    public EnderecoDTO obterEnderecoPorCep(String cep) {
        log.warn("Método de fallback executado para ..obterEnderecoPorCep");
        return EnderecoDTO.builder().complemento("Fallback").build();
    }
}
