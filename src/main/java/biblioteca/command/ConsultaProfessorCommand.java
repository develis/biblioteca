package biblioteca.command;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;

public class ConsultaProfessorCommand extends Command{
    public ConsultaProfessorCommand(final BibliotecaDAOImpl bibliotecaDAO, final UsuarioDAOImpl usuarioDAO, final String comando) {
        super(bibliotecaDAO, usuarioDAO, comando);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
