package com.letscode.banco.service;

import com.letscode.banco.dto.TransacaoRequest;
import com.letscode.banco.dto.TransacaoResponse;
import com.letscode.banco.model.Transacao;

public interface TransacaoService {
    TransacaoResponse create(TransacaoRequest transacaoRequest);

    Transacao getById(Integer id);
}
