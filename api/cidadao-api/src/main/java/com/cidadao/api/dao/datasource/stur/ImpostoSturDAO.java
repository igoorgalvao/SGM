package com.cidadao.api.dao.datasource.stur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cidadao.api.dto.GerarImpostoDTO;
import com.cidadao.api.entidade.stur.ImpostoMunicipal;

public interface ImpostoSturDAO extends JpaRepository<ImpostoMunicipal, Long> {

	@Query(" SELECT ENT FROM ImpostoMunicipal                   ENT                                                                            "
			+ " INNER JOIN FETCH ENT.pagador                    PAGADOR                                                                        "
			+ " INNER JOIN FETCH PAGADOR.tipoPessoa             TP                                                                             "
			+ " 	WHERE  TP.id           = :#{#dto.getTipoPessoa()}                                                                          "
			+ " 	AND    ENT.cep         = :#{#dto.getCepSemMascara()}                                                                                 "
			+ " 	AND    ENT.numero      = :#{#dto.getNumero()}                                                                              "
			+ " 	AND    PAGADOR.cpfCnpj = :#{#dto.getCpfCnpjSemMascara()}                                                                             ")
	@Transactional(readOnly = true)
	Optional<ImpostoMunicipal> consultarImpostoMunicipal(@Param("dto") GerarImpostoDTO dto);

}
