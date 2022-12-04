package biblioteca.model;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(final Long id, final String nome) {
        super(id, nome, 3, 3, Hierarquia.GRAD);
    }
}
