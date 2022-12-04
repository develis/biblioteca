package biblioteca;

import java.util.List;

import biblioteca.model.Exemplar;
import biblioteca.model.Livro;

public interface BibliotecaDAO {
    List<Livro> findLivros();

    Livro findLivroById(int id);

    Exemplar findLivroByExemplar(Long codigo_exemplar);
}
