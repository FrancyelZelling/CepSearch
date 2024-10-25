import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zellling.Utils.CepSearch;
import com.zellling.Utils.Writer;
import com.zellling.models.AdressCep;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        Writer writer = new Writer();
        System.out.println("Digite o cep para buscar(sem espaços ou hífen):");
        var cep = scanner.nextLine();

        CepSearch busca = new CepSearch();

        try {
            AdressCep adress = busca.search(cep);
            writer.writeFile(gson.toJson(adress));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação.");
        }
        scanner.close();
    }
}