package com.zellling.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zellling.models.AdressCep;

public class CepSearch {
  public AdressCep search(String cep) {
    var url = "https://viacep.com.br/ws/" + cep + "/json/";
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .create();
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      var json = response.body();
      return gson.fromJson(json, AdressCep.class);
    } catch (Exception e) {
      throw new RuntimeException("Não foi possível obter valores com este cep.");
    }
  }
}
