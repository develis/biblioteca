package biblioteca;

import biblioteca.model.Usuario;

public interface UsuariosDAO {
    Usuario findById(Long id);
}
