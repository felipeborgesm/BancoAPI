package com.letscode.banco.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ContaAgenciaView {

    @Value("#{target.agencia + ' - ' + target.numero}")
    String getAgenciaNumero();

    @Value("#{target.tipoConta + ' - ' + target.saldo}")
    String getAgenciaNumeroTipoContaSaldo();

    UsuarioView getUsuario();

}
