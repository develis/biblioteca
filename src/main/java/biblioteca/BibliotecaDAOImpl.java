package biblioteca;

import java.util.List;

import biblioteca.model.Exemplar;
import biblioteca.model.Livro;

public class BibliotecaDAOImpl implements BibliotecaDAO {
    @Override
    public List<Livro> findLivros() {
        return Biblioteca.livros;
    }

    @Override
    public Livro findLivroById(int id) {
        return Biblioteca.livros
                .stream()
                .filter(livro -> id == livro.getId())
                .findAny()
                .orElse(null);
    }

    @Override
    public Exemplar findLivroByExemplar(final Long codigo_exemplar) {
        Exemplar target;
        for (Livro livro: Biblioteca.livros) {
            for (Exemplar exemplar: livro.getExemplares()) {
                if (exemplar.getId() == codigo_exemplar) {
                    return exemplar;
                }
            }
        }
        return null;
    }

}
