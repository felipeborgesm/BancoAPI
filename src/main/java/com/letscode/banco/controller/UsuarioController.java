package com.letscode.banco.controller;

import com.letscode.banco.dto.UsuarioRequest;
import com.letscode.banco.dto.UsuarioResponse;
import com.letscode.banco.model.Usuario;
import com.letscode.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

  @Autowired UsuarioService usuarioService;

  @GetMapping
  public Page<Usuario> getAll(
      @RequestParam(required = false) String nome,
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "3") int size) {
    return usuarioService.getAll(nome, page, size);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest) {
    return usuarioService.create(usuarioRequest);
  }

  @GetMapping("/{id}")
  public Usuario getById(@PathVariable Integer id) {
    return usuarioService.getById(id);
  }

  @GetMapping("/cpf")
  public Page<UsuarioResponse> getAllByCpf(
      @RequestParam String cpf,
      @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "3") int size) {
    return usuarioService.getAllByCpf(cpf, page, size);
  }

  @PutMapping("/{id}")
  public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
    return usuarioService.update(usuarioRequest, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    usuarioService.delete(id);
  }
}
