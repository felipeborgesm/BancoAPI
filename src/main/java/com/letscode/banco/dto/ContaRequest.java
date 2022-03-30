package com.letscode.banco.dto;

import com.letscode.banco.model.TipoConta;
import com.letscode.banco.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter @Setter
public class ContaRequest {
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private BigDecimal saldo;
}
