package com.fag.lucasmartins.arquitetura_software.core.domain.vo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class CpfVO {
    private final String cpf;

    public CpfVO(String cpf) {
        if (cpf == null) {
            throw new DomainException("Erro: CPF não pode ser nulo");
        }

        String cpfLimpo = limparCpf(cpf);
        validate(cpfLimpo);
        this.cpf = cpfLimpo;
    }

    private void validate(String cpf) {
        if (cpf.length() != 11) {
            throw new DomainException("Erro: CPF não pode ter mais ou menos que 11 digitos");
        }
        if(isNumerosRepetidos(cpf) || !isCalculoValido(cpf)) {
            throw new DomainException("Erro: CPF inválido");
        }
    }

    // deixa somente números, serve para limpar os caracteres especiais caso cheguem aqui
    private String limparCpf(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    // valida se os números estão repetidos
    private boolean isNumerosRepetidos(String cpf) {
        return cpf.matches("(\\d)\\1{10}");
    }

    // a lógica do cálculo do CPF peguei com IA, para facilitar, o convencional seria pegar pronto então acho tranquilo

    private boolean isCalculoValido(String cpf) {
        try {
            int d1 = calcularDigito(cpf.substring(0, 9), 10);
            int d2 = calcularDigito(cpf.substring(0, 9) + d1, 11);

            return cpf.equals(cpf.substring(0, 9) + d1 + d2);
        } catch (Exception e) {
            return false;
        }
    }

    private int calcularDigito(String str, int pesoInicial) {
        int soma = 0;
        int peso = pesoInicial;

        for (int i = 0; i < str.length(); i++) {
            soma += Character.getNumericValue(str.charAt(i)) * peso--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    public String getCpf() {
        return cpf;
    }
}