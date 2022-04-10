package com.letscode.banco.controller;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.model.TipoConta;
import com.letscode.banco.projection.ContaView;
import com.letscode.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

  @Autowired ContaService contaService;

  @PostMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ContaResponse create(@RequestBody ContaRequest contaRequest, @PathVariable Integer id) {
    return contaService.create(contaRequest, id);
  }

  @GetMapping("/{id}")
  public Conta getById(@PathVariable Integer id) {
    return contaService.getById(id);
  }

  @GetMapping("/view")
  public List<ContaView> getAllContaViewByTipoConta(@RequestParam TipoConta tipoConta) {
    return contaService.getAllViewByTipoConta(tipoConta);
  }

  @GetMapping("/agencia")
  public Page<ContaView> getAllByAgencia (
          @RequestParam Integer agencia,
          @RequestParam(required = false, defaultValue = "0") int page,
          @RequestParam(required = false, defaultValue = "3") int size) {
    return contaService.getAllByAgencia(agencia, page, size);
  }

  @PutMapping("/{id}")
  public Conta update(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
    return contaService.update(contaRequest, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    contaService.delete(id);
  }

}