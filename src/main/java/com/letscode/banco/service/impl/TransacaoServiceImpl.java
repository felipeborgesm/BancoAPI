package com.letscode.banco.service.impl;

import com.letscode.banco.dto.TransacaoRequest;
import com.letscode.banco.dto.TransacaoResponse;
import com.letscode.banco.model.Transacao;
import com.letscode.banco.repository.TransacaoRepository;
import com.letscode.banco.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Override
    public TransacaoResponse create(TransacaoRequest transacaoRequest) {
        Transacao transacao = new Transacao(transacaoRequest);
        transacaoRepository.save(transacao);
        return new TransacaoResponse(transacao);
    }

    @Override
    public Transacao getById(Integer id) {
        return transacaoRepository.findById(id).orElseThrow();
    }


}
