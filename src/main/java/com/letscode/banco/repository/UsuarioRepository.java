package com.letscode.banco.repository;

import com.letscode.banco.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeAndCpf(String nome, String cpf);
    List<Usuario> findByNomeIs(String nome);
    List<Usuario> findByNomeIsNot(String nome);
}