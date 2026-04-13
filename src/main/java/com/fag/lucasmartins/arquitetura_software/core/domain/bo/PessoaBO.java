package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import com.fag.lucasmartins.arquitetura_software.core.domain.vo.CpfVO;
import com.fag.lucasmartins.arquitetura_software.core.domain.vo.EmailVO;
import com.fag.lucasmartins.arquitetura_software.core.domain.vo.TelefoneVO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PessoaBO {

    private String nomeCompleto;
    private CpfVO cpf;
    private LocalDate dataNascimento;
    private EmailVO email;
    private TelefoneVO telefone;

    public PessoaBO() {}

    // construtor para facilitar a criação dos value objects, mantendo as validações dentro do domínio
    public PessoaBO(
            String nomeCompleto,
            String cpf,
            LocalDate dataNascimento,
            String email,
            String telefone){
        this.nomeCompleto = nomeCompleto;
        this.cpf = new CpfVO(cpf);
        this.dataNascimento = dataNascimento;
        this.email = new EmailVO(email);
        this.telefone = new TelefoneVO(telefone);
    }

    public void validarMaiorDeIdade() {
        if (dataNascimento == null) {
            throw new DomainException("Erro: Data de nascimento não pode ser nula");
        }

        // Calcula a diferença exata em anos entre a data de nascimento e hoje
        long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());

        if (idade < 18) {
            throw new DomainException("Erro: Deve ter pelo menos 18 anos. Idade informada: " + idade);
        }
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public CpfVO getCpf() {
        return cpf;
    }
    public String getCpfString() {
        return cpf.getCpf();
    }

    public void setCpf(CpfVO cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EmailVO getEmail() {
        return email;
    }
    public String getEmailString() {
        return email.getEmail();
    }

    public void setEmail(EmailVO email) {
        this.email = email;
    }

    public TelefoneVO getTelefone() {
        return telefone;
    }
    public String getTelefoneString() {
        return telefone.getTelefone();
    }

    public void setTelefone(TelefoneVO telefone) {
        this.telefone = telefone;
    }
}
