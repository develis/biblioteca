package biblioteca.command;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;
import biblioteca.model.Emprestimo;
import biblioteca.model.Exemplar;
import biblioteca.model.Livro;
import biblioteca.model.Reserva;

public class ConsultaLivroCommand extends Command {

    public ConsultaLivroCommand(final BibliotecaDAOImpl bibliotecaDAO, final UsuarioDAOImpl usuarioDAO, final String comando) {
        super(bibliotecaDAO, usuarioDAO, comando);
    }

    @Override
    public boolean execute() {
        Integer id_livro = Integer.valueOf(splitCommand()[1]);
        Livro livro = bibliotecaDAO.findLivroById(id_livro);

        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Reservas: " + livro.getReservas().size());

        if (livro.getReservas().size() > 0) {
            for (Reserva reserva: livro.getReservas()) {
                System.out.println("Usuário que reservou: " + usuarioDAO.findById(reserva.getId_usuario()));
            }
        }

        for (Exemplar exemplar: livro.getExemplares()) {
            if (!exemplar.isEmprestado()) {
                System.out.println("Exemplar: " + exemplar.getId() + " [DISPONÍVEL]");
            }
        }

        for (Emprestimo emprestimo: livro.getEmprestimos()) {
            System.out.println("Exemplar : " + emprestimo.getExemplar().getId_livro() + " [EMPRESTADO] para: " + usuarioDAO.findById(emprestimo.getId_usuario()).getNome());
            System.out.println("Data do empréstimo: " + emprestimo.getData_emprestimo());
            System.out.println("Data da devolução: " + emprestimo.getData_devolucao());
        }

        return true;
    }
}
