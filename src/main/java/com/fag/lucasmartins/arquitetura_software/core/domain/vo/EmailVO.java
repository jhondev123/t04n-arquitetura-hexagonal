package com.fag.lucasmartins.arquitetura_software.core.domain.vo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class EmailVO {
    private String email;

    public EmailVO(String email) {
        validate(email);
        this.email = email;
    }
    private void validate(String email) {
        if(email == null || email.isEmpty()){
            throw new DomainException("Error: E-mail é obrigatório");
        }
        if(!email.contains("@") || !email.contains(".")){
            throw new DomainException("Error: E-mail inválido");
        }
    }
    public String getEmail() {
        return email;
    }
}
