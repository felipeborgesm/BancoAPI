package com.letscode.banco.service.impl;

import com.letscode.banco.dto.UsuarioRequest;
import com.letscode.banco.dto.UsuarioResponse;
import com.letscode.banco.model.Usuario;
import com.letscode.banco.repository.UsuarioRepository;
import com.letscode.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired UsuarioRepository usuarioRepository;

  @Override
  public List<Usuario> getAll(String nome) {
    if (nome != null) {
      return usuarioRepository.findByNome(nome);
    } else {
      return usuarioRepository.findAll();
    }
  }

  @Override
  public UsuarioResponse create(UsuarioRequest usuarioRequest) {
    Usuario usuario = new Usuario(usuarioRequest);
    usuarioRepository.save(usuario);
    return new UsuarioResponse(usuario);
  }

  @Override
  public Usuario getById(Integer id) {
    return usuarioRepository.findById(id).orElseThrow();
  }

  public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
    Usuario usuario = usuarioRepository.findById(id).orElseThrow();

    usuario.setNome(usuarioRequest.getNome());
    usuario.setCpf(usuarioRequest.getCpf());
    usuario.setSenha(usuarioRequest.getSenha());

    return usuarioRepository.save(usuario);
  }

  public void delete(Integer id) {
    var usuario = usuarioRepository.findById(id).orElseThrow();
    usuarioRepository.delete(usuario);
  }
}
