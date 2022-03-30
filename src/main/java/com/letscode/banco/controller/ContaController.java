package com.letscode.banco.controller;

import com.letscode.banco.dto.ContaRequest;
import com.letscode.banco.dto.ContaResponse;
import com.letscode.banco.model.Conta;
import com.letscode.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/conta/{id}")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping
    public ContaResponse create(@RequestBody ContaRequest contaRequest, @PathVariable Integer id) {
        return contaService.create(contaRequest, id);
    }

    @GetMapping
    public Conta getById(@PathVariable Integer id) {
        return contaService.getById(id);
    }
}
