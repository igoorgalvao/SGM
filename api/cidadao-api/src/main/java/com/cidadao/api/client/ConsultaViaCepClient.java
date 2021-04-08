package com.cidadao.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep", fallback = ConsultaViaCepClientFallback.class, configuration = ConsultaViaCepConfig.class)
public interface ConsultaViaCepClient {

    @GetMapping("{cep}/json")
    EnderecoDTO obterEnderecoPorCep(@PathVariable("cep") String cep);
}
