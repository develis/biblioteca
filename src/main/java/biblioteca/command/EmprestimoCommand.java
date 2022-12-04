package biblioteca.command;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;
import biblioteca.model.Livro;

/*
O sistema deve permitir o empréstimo de livros. Durante o empréstimo, o usuário informará o comando “emp” seguido do código do usuário e do código do
livro, separados por espaço em branco. Ex.: “emp 123 100”. Caso o usuário tenha uma reserva feita previamente por ele para o dado livro, a reserva deve
ser excluída e o empréstimo efetivado. Ao final do procedimento o sistema deve emitir uma mensagem de sucesso ou insucesso, que mencione o nome do
usuário e o título do livro. Se for uma mensagem de insucesso, ela deve também mencionar o motivo do insucesso.
O empréstimo do livro só será concretizado para um aluno de graduação ou um aluno de pós-graduação se: (i) houver a disponibilidade de algum
exemplar daquele livro na biblioteca; (ii) o usuário não estiver “devedor” de um livro em atraso; (iii) forem obedecidas as regras específicas
daquele tipo de usuário no que se refere à quantidade máxima de empréstimos, de acordo com a Tabela 2; (iv) a quantidade de reservas existentes do
livro for menor do que a quantidade de exemplares disponíveis, caso o usuário não tenha reserva para
ele; (v) a quantidade de reservas for maior ou igual a de exemplares, mas uma das reservas é do usuário; e (vi) o usuário não tiver nenhum
empréstimo em curso de um exemplar daquele mesmo livro.
O empréstimo do livro só será concretizado para um professor se: (i) houver a disponibilidade de algum exemplar daquele livro na biblioteca; e (ii)
o usuário não estiver “devedor” de um livro em atraso.
Note que os professores não tem empréstimo negado caso haja reservas para aquele livro e não tem limite da quantidade de livros que pode pegar
emprestado.
É sabido que nesse tipo de domínio essas regras estão sujeitas a frequentes mudanças. Além disso, podem surgir novos tipos de usuário para os
quais as regras de empréstimo sejam diferentes das já existentes para professor e alunos de graduação e de pós.
* */

public class EmprestimoCommand extends Command{
    public EmprestimoCommand(final BibliotecaDAOImpl bibliotecaDAO, final UsuarioDAOImpl usuarioDAO, final String comando) {
        super(bibliotecaDAO, usuarioDAO, comando);
    }

    @Override
    public boolean execute() {
        Long id_usuario = Long.valueOf(splitCommand()[1]);
        Integer id_livro = Integer.valueOf(splitCommand()[2]);

        return false;
    }
}
