package com.br.devForTech.ApiAngular.modelViews;

public class Erro {
    public Erro(String mensagem){
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
}
