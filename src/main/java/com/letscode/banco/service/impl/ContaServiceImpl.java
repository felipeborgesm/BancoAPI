package com.letscode.banco.service.impl;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.repository.ContaRepository;
import com.letscode.banco.service.ContaService;
import com.letscode.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {
  @Autowired ContaRepository contaRepository;

  @Autowired UsuarioService usuarioService;

  @Override
  public ContaResponse create(ContaRequest contaRequest, Integer id) {
    var usuario = usuarioService.getById(id);
    Conta conta = new Conta(contaRequest);
    conta.setUsuario(usuario);
    contaRepository.save(conta);
    return new ContaResponse(conta);
  }

  @Override
  public Conta getById(Integer id) {
    return contaRepository.findById(id).orElseThrow();
  }

}
