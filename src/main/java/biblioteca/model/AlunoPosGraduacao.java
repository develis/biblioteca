package biblioteca.model;

public class AlunoPosGraduacao extends Usuario{

    public AlunoPosGraduacao(final Long id, final String nome) {
        super(id, nome, 4, 4, Hierarquia.POS_GRAD);
    }
}
