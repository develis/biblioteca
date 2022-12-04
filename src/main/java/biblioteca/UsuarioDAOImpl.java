package biblioteca;

import biblioteca.model.Usuario;

public class UsuarioDAOImpl implements UsuariosDAO{
    @Override
    public Usuario findById(final Long id) {
        return GeradorUsuarios.usuarios
                .stream()
                .filter(usuario -> id == usuario.getId())
                .findAny()
                .orElse(null);
    }
}
