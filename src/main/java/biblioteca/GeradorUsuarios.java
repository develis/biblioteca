package biblioteca;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import biblioteca.model.Livro;
import biblioteca.model.Usuario;

public abstract class GeradorUsuarios {
    public static List<Usuario> usuarios = inicializarUsuarios();

    private static List<Usuario> inicializarUsuarios() {
        usuarios = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(
                    new FileReader("src/main/resources/usuarios.json"));

            for (Object jsonLivro: data) {
                Usuario usuario = gson.fromJson(jsonLivro.toString(), Usuario.class);

                usuarios.add(usuario);
            }

            return usuarios;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
