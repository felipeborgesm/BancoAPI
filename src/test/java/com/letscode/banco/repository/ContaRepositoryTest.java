package com.letscode.banco.repository;

import com.letscode.banco.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;

@DataJpaTest
@Profile("test")
public class ContaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void validar_findAll_vazio_se_repository_em_branco() {
        var conta = usuarioRepository.findAll();
        Assertions.assertEquals(Arrays.asList(), conta);
    }

    @Test
    public void trazer_usuarios_cadastrados_no_find_all() {
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setSenha("12345677");
        usuario.setCpf("12312312312");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Anderson");
        usuario2.setSenha("12345677");
        usuario2.setCpf("12312312313");

        entityManager.persist(usuario);
        entityManager.persist(usuario2);

        var usuarios = usuarioRepository.findAll();

        Assertions.assertEquals(Arrays.asList(usuario, usuario2), usuarios);
    }

}
