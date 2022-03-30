package com.letscode.banco.service;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest, Integer id);

    Conta getById(Integer id);
}
