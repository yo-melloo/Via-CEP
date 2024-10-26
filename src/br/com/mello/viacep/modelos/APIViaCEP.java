package br.com.mello.viacep.modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIViaCEP {

    public Endereco consultarCEP(String cep){
        Gson gson = new Gson().newBuilder()
                .setPrettyPrinting()
                .create();

        URI uriDaApi = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        try {
            //Inicializando requisição:
            HttpClient clienteHttp = HttpClient.newHttpClient();

            // Requisição (GET):
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(uriDaApi)
                    .build();

            //Armazenando Response (recebe um HTML):
            HttpResponse<String> res = clienteHttp
                    .send(req, HttpResponse.BodyHandlers.ofString());

            //Desserializando a Response com Gson:
            String resJson = res.body();
            EnderecoRecord enderecoRecord = gson.fromJson(resJson, EnderecoRecord.class);
            return new Endereco(enderecoRecord);

        } catch (Exception e){
            throw new RuntimeException("Não consegui chegar neste endereço");
        }
    }
}
