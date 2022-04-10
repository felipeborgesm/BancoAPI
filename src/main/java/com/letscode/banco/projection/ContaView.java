package com.letscode.banco.projection;

import com.letscode.banco.model.TipoConta;
import org.springframework.beans.factory.annotation.Value;

public interface ContaView {
    Integer getSaldo();

    TipoConta getTipoConta();

    @Value("#{target.numero + ' - ' + target.agencia}")
    String getNumeroAgencia();

    UsuarioView getUsuario();
}
