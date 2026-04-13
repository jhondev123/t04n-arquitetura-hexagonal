package com.fag.lucasmartins.arquitetura_software.core.domain.vo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class TelefoneVO {
    private final String telefone;

    public TelefoneVO(String telefone) {
        if (telefone == null) {
            throw new DomainException("Erro: Telefone não pode ser nulo");
        }

        String telefoneLimpo = limpaTelefone(telefone);
        validate(telefoneLimpo);
        this.telefone = telefoneLimpo;
    }

    private void validate(String telefone) {
        // Valida se tem entre 10 e 11 caracteres
        if (telefone.length() != 11) {
            throw new DomainException("Erro: Telefone deve ter 10 ou 11 dígitos (com DDD)");
        }

        // ideias de validações peguei com a IA, eu teria pesquisado a melhor forma de validar um telefone.
        if (Integer.parseInt(telefone.substring(0, 1)) == 0) {
            throw new DomainException("Erro: DDD inválido");
        }

        if (telefone.length() == 11 && telefone.charAt(2) != '9') {
            throw new DomainException("Erro: O nono dígito de celulares deve ser 9");
        }
    }

    private String limpaTelefone(String telefone) {
        // Deixa somente números
        return telefone.replaceAll("\\D", "");
    }

    public String getTelefone() {
        return telefone;
    }
}