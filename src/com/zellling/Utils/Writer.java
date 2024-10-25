package com.zellling.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
  public void writeFile(String string) {
    try {
      FileWriter file = new FileWriter("cep.json");
      file.write(string);
      file.close();
      System.out.println("Arquivo gravado com sucesso!");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println("não foi possível gravar o arquivo");
    }
  }
}
