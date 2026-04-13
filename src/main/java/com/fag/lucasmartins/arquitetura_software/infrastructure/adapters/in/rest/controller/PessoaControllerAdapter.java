package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.ProdutoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }
    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrar(@RequestBody PessoaDTO pessoaDTO) {

        PessoaBO pessoaBo = PessoaDTOMapper.toBo(pessoaDTO);

        PessoaBO pessoaCriadaBo = pessoaServicePort.salvar(pessoaBo);

        PessoaDTO pessoaCriadaDTO = PessoaDTOMapper.toDto(pessoaCriadaBo);

        return ResponseEntity.status(201).body(pessoaCriadaDTO);
    }
}
