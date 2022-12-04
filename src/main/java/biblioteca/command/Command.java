package biblioteca.command;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;

public abstract class Command {
    public BibliotecaDAOImpl bibliotecaDAO;
    public String comando;

    public UsuarioDAOImpl usuarioDAO;

    public Command(final BibliotecaDAOImpl bibliotecaDAO, UsuarioDAOImpl usuarioDAO,final String comando) {
        this.bibliotecaDAO = bibliotecaDAO;
        this.comando = comando;
        this.usuarioDAO = usuarioDAO;
    }

    public abstract boolean execute();

    public String getComando() {
        return comando;
    }

    public String[] splitCommand() {
        return comando.split("\\s+");
    }
}
