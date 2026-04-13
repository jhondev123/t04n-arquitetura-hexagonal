package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.vo.CpfVO;
import com.fag.lucasmartins.arquitetura_software.core.domain.vo.EmailVO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {
    public PessoaDTOMapper() {}

    public static PessoaBO toBo (PessoaDTO pessoaDTO) {
        return new PessoaBO(
                pessoaDTO.getNomeCompleto(),
                pessoaDTO.getCpf(),
                pessoaDTO.getDataNascimento(),
                pessoaDTO.getEmail(),
                pessoaDTO.getTelefone()
        );
    }
    public static PessoaDTO toDto (PessoaBO pessoaBO) {
        final PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNomeCompleto(pessoaBO.getNomeCompleto());
        pessoaDTO.setDataNascimento(pessoaBO.getDataNascimento());
        pessoaDTO.setCpf(pessoaBO.getCpfString());
        pessoaDTO.setEmail(pessoaBO.getEmailString());
        pessoaDTO.setTelefone(pessoaBO.getTelefoneString());

        return pessoaDTO;
    }

}
