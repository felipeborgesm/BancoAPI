package com.letscode.banco.service.impl;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoConta;
import com.letscode.banco.projection.ContaView;
import com.letscode.banco.repository.ContaRepository;
import com.letscode.banco.service.ContaService;
import com.letscode.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

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

  @Override
  public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta) {
    return contaRepository.findAllByTipoConta(tipoConta);
  }

  @Override
  public Conta update(ContaRequest contaRequest, Integer id) {
    Conta conta = contaRepository.findById(id).orElseThrow();

    conta.setAgencia(conta.getAgencia());
    conta.setNumero(contaRequest.getNumero());
    conta.setTipoConta(contaRequest.getTipoConta());

    return contaRepository.save(conta);
  }

  @Override
  public void delete(Integer id) {
    var conta = contaRepository.findById(id).orElseThrow();
    contaRepository.delete(conta);

  }

  @Override
  public Page<ContaView> getAllByAgencia(Integer agencia, int page, int size) {
    PageRequest pageRequest = PageRequest.of(
            page, size, Sort.Direction.ASC, "agencia"
    );
    return contaRepository.findByAgencia(agencia, pageRequest);
  }

}
