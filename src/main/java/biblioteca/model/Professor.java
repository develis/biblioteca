package biblioteca.model;

public class Professor extends Usuario{
    public Professor(final Long id, final String nome) {
        super(id, nome, 7, 0, Hierarquia.PROFESSOR);
    }
}
