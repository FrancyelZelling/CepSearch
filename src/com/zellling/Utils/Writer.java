package com.zellling.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zellling.models.AdressCep;

public class Writer {
  public void writeFile(AdressCep adressCep) {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setPrettyPrinting()
        .create();
    try {
      FileWriter file = new FileWriter("cep.json");
      file.write(gson.toJson(adressCep));
      file.close();
      System.out.println("Arquivo gravado com sucesso!");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println("não foi possível gravar o arquivo");
    }
  }
}
