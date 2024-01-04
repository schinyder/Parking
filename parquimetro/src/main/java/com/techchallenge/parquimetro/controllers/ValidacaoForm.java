package com.techchallenge.parquimetro.controllers;

import java.util.ArrayList;
import java.util.List;

import com.techchallenge.parquimetro.exception.DefaultError;

public class ValidacaoForm extends DefaultError {

    private List<ValidacaoCampo> mensagens = new ArrayList<ValidacaoCampo>();

    public List<ValidacaoCampo> getMensagens() {
        return mensagens;
    }

    public void  addMenssagens(String campo, String mensagem) {
        mensagens.add(new ValidacaoCampo(campo, mensagem));
    }

}
