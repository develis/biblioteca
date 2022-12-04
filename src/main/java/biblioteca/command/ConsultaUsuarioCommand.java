package biblioteca.command;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;
import biblioteca.model.Emprestimo;
import biblioteca.model.Reserva;
import biblioteca.model.Usuario;

public class ConsultaUsuarioCommand extends Command{
    public ConsultaUsuarioCommand(final BibliotecaDAOImpl bibliotecaDAO, final UsuarioDAOImpl usuarioDAO, final String comando) {
        super(bibliotecaDAO, usuarioDAO, comando);
    }

    @Override
    public boolean execute() {
        Integer id_usuario = Integer.valueOf(splitCommand()[1]);
        Usuario usuario = usuarioDAO.findById(Long.valueOf(id_usuario));

        for (Emprestimo emprestimo: usuario.getEmprestimos()) {
            System.out.println("Empréstimo");
            System.out.println("Livro: " + emprestimo.getExemplar().getTitulo());
            System.out.println("Data empréstimo: " + emprestimo.getData_emprestimo());
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("Data devolução: " + emprestimo.getData_devolucao());
        }

        for (Reserva reserva: usuario.getReservas()) {
            System.out.println("Reserva");
            System.out.println("Livro: " + reserva.getExemplar().getTitulo());
            System.out.println("Data da reserva: " + reserva.getData_reserva());
        }

        return true;
    }
}
