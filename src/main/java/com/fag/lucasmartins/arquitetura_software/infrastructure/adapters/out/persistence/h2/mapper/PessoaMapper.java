package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {
    public PessoaMapper(){}

    public static PessoaEntity toEntity(PessoaBO pessoaBO){
        PessoaEntity entity = new PessoaEntity();
        entity.setNomeCompleto(pessoaBO.getNomeCompleto());
        entity.setCpf(pessoaBO.getCpfString());
        entity.setDataNascimento(pessoaBO.getDataNascimento());
        entity.setEmail(pessoaBO.getEmailString());
        entity.setTelefone(pessoaBO.getTelefoneString());

        return entity;
    }
    public static PessoaBO toBO(PessoaEntity pessoaEntity){
        return new PessoaBO(
                pessoaEntity.getNomeCompleto(),
                pessoaEntity.getCpf(),
                pessoaEntity.getDataNascimento(),
                pessoaEntity.getEmail(),
                pessoaEntity.getTelefone()
        );
    }

}
