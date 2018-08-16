/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeestoque.Models;

/**
 *
 * @author Guibs
 */
public class FuncionarioModelo {
    private int funcionario_id;
    private String funcionario_nome;
    private String funcionario_email;
    private String funcionario_celular;
    private String funcionario_login;
    private String funcionario_senha;

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public String getFuncionario_nome() {
        return funcionario_nome;
    }

    public void setFuncionario_nome(String funcionario_nome) {
        this.funcionario_nome = funcionario_nome;
    }

    public String getFuncionario_email() {
        return funcionario_email;
    }

    public void setFuncionario_email(String funcionario_email) {
        this.funcionario_email = funcionario_email;
    }

    public String getFuncionario_celular() {
        return funcionario_celular;
    }

    public void setFuncionario_celular(String funcionario_celular) {
        this.funcionario_celular = funcionario_celular;
    }

    public String getFuncionario_login() {
        return funcionario_login;
    }

    public void setFuncionario_login(String funcionario_login) {
        this.funcionario_login = funcionario_login;
    }

    public String getFuncionario_senha() {
        return funcionario_senha;
    }

    public void setFuncionario_senha(String funcionario_senha) {
        this.funcionario_senha = funcionario_senha;
    }

    
}
