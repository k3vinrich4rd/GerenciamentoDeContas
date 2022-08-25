package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarNovaConta(@RequestBody ContasAPagarModel contasAPagarModel){
        ContasAPagarModel contas = contasAPagarService.cadastrarContas(contasAPagarModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }



}
