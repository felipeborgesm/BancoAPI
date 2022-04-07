package com.letscode.banco.service;

import com.letscode.banco.dto.UsuarioRequest;
import com.letscode.banco.dto.UsuarioResponse;
import com.letscode.banco.model.Usuario;
import org.springframework.data.domain.Page;

public interface UsuarioService {
    Page<Usuario> getAll(String nome, int page, int size);

    Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size);

    UsuarioResponse create(UsuarioRequest usuarioRequest);

    Usuario getById(Integer id);

    Usuario update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);

}
