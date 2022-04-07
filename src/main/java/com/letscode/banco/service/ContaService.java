package com.letscode.banco.service;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoConta;
import com.letscode.banco.projection.ContaView;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest, Integer id);

    Conta getById(Integer id);

    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);

    Conta update(ContaRequest contaRequest, Integer id);

    void delete(Integer id);

    Page<ContaResponse> getAllByAgencia(Integer agencia, int page, int size);
}
