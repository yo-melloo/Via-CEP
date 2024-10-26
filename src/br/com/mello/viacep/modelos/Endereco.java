package br.com.mello.viacep.modelos;

public class Endereco {
    private String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String estado;
    String codigoDDD;

    public String getCep() {
        return cep;
    }

    public Endereco (EnderecoRecord enderecoRecord){
        this.cep = enderecoRecord.cep();
        this.logradouro = enderecoRecord.logradouro();
        this.complemento = enderecoRecord.complemento();
        this.bairro = enderecoRecord.bairro();
        this.localidade = enderecoRecord.localidade();
        this.uf = enderecoRecord.uf();
        this.estado = enderecoRecord.estado();
        this.codigoDDD = enderecoRecord.codigoDDD();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s - %s.", this.logradouro, this.bairro, this.localidade, this.uf);
    }
}
