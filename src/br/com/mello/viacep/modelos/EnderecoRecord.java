package br.com.mello.viacep.modelos;

public record EnderecoRecord(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String estado, String codigoDDD) {
}
