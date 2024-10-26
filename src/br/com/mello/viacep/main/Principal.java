package br.com.mello.viacep.main;

import br.com.mello.viacep.modelos.APIViaCEP;
import br.com.mello.viacep.modelos.Endereco;
import br.com.mello.viacep.modelos.GeradorDeArquivo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        APIViaCEP viaCEP = new APIViaCEP();
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um CEP (sem pontação, apenas números): ");
        String cep = leitura.nextLine();

        try {
            Endereco endereco = viaCEP.consultarCEP(cep);
            System.out.println(endereco);
            GeradorDeArquivo salvarEndereco = new GeradorDeArquivo();
            salvarEndereco.salvarJson(endereco);

        } catch (Exception e) {
            System.out.println("Não foi possível chegar neste endereço");
            throw new RuntimeException("Ocorreu um erro");
        }

    }
}
