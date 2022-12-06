package biblioteca.command;

import static java.lang.System.exit;

import java.util.Date;

import biblioteca.BibliotecaDAOImpl;
import biblioteca.UsuarioDAOImpl;
import biblioteca.model.Emprestimo;
import biblioteca.model.Exemplar;
import biblioteca.model.Hierarquia;
import biblioteca.model.Livro;
import biblioteca.model.Reserva;
import biblioteca.model.Status;
import biblioteca.model.Usuario;

public class EmprestimoCommand extends Command{
    public EmprestimoCommand(final BibliotecaDAOImpl bibliotecaDAO, final UsuarioDAOImpl usuarioDAO, final String comando) {
        super(bibliotecaDAO, usuarioDAO, comando);
    }

    @Override
    public boolean execute() {
        Exemplar exemplar = new Exemplar();
        Long id_usuario = Long.valueOf(splitCommand()[1]);
        Integer id_livro = Integer.valueOf(splitCommand()[2]);

        Usuario usuario = usuarioDAO.findById(id_usuario);
        Livro livro = bibliotecaDAO.findLivroById(id_livro);
        boolean requisitos = requisitosAlunos(usuario, livro);

        if (livro.getExemplaresDisponiveis().isEmpty()) {
            System.out.println("- Operação não sucedeu.");
            System.out.println("* Não há exemplares disponíveis.");
            exit(1);
            return false;
        }

        if ((usuario.getHierarquia() == Hierarquia.GRAD || usuario.getHierarquia() == Hierarquia.POS_GRAD) && !requisitos) {
            System.out.println("- Operação não sucedeu.");
            exit(1);
            return false;
        }

        if (usuario.getHierarquia() == Hierarquia.PROFESSOR && temEmprestimoAtivo(usuario, livro)) {
            exit(1);
            return false;
        }

        if (!livro.getExemplaresDisponiveis().isEmpty()) {
            exemplar = finalizarReservaUsuario(usuario, id_livro);
            finalizarReservaLivro(livro, id_livro);
        }

        if (exemplar.getId_livro() == null) {
            Exemplar exemplarDisponivel = livro.getExemplaresDisponiveis().get(0);

            exemplar.setId(exemplarDisponivel.getId());
            exemplar.setId_livro(exemplarDisponivel.getId_livro());
            exemplar.setEmprestado(true);
            exemplar.setTitulo(exemplarDisponivel.getTitulo());

            exemplarDisponivel.setEmprestado(true);
        }

        Emprestimo emprestimo = new Emprestimo(id_usuario, exemplar, new Date());
        Date data_devolucao = new Date(System.currentTimeMillis() + (usuario.getTempo_emprestimo() * 86400000));

        emprestimo.setData_devolucao(data_devolucao);

        usuario.addEmprestimo(emprestimo);
        livro.addEmprestimo(emprestimo);

        return true;
    }

    private Exemplar finalizarReservaUsuario(Usuario usuario, Integer id_livro) {
        for (Reserva reserva: usuario.getReservas()) {
            if (reserva.getExemplar().getId_livro().intValue() == id_livro) {
                usuario.getReservas().get(usuario.getReservas().indexOf(reserva)).setStatus(Status.FINALIZADO);
                return usuario.getReservas().get(usuario.getReservas().indexOf(reserva)).getExemplar();
            }
        }
        return new Exemplar();
    }

    private Exemplar finalizarReservaLivro(Livro livro, Integer id_livro) {
        for (Reserva reserva: livro.getReservas()) {
            if (reserva.getExemplar().getId_livro().intValue() == id_livro) {
                livro.getReservas().get(livro.getReservas().indexOf(reserva)).setStatus(Status.FINALIZADO);
                return livro.getReservas().get(livro.getReservas().indexOf(reserva)).getExemplar();
            }
        }

        return new Exemplar();
    }

    private boolean requisitosAlunos(Usuario usuario, Livro livro) {
        if (
                livrosEmAtraso(usuario) ||
                        limiteEmprestimos(usuario) ||
                        temEmprestimoAtivo(usuario, livro) ||
                        !(!alunoTemReserva(usuario, livro) && livro.getReservas().size() < livro.getExemplaresDisponiveis().size()) ||
                        !(alunoTemReserva(usuario, livro) && livro.getReservas().size() >= livro.getExemplaresDisponiveis().size())
        ) {
            return false;
        }

        return true;
    }

    private boolean alunoTemReserva(Usuario usuario, Livro livro) {
        for (Reserva reserva: usuario.getReservas()) {
            if (reserva.getExemplar().getId_livro().intValue() == livro.getId()) {
                return true;
            }
        }

        return false;
    }

    private boolean temEmprestimoAtivo(Usuario usuario, Livro livro) {
        for (Emprestimo emprestimo: usuario.getEmprestimos()) {
            if (emprestimo.getExemplar().getId_livro() == livro.getId()) {
                System.out.println("* Usuário possui empréstimo ativo");
                return true;
            }
        }

        return false;
    }

    private boolean limiteEmprestimos(Usuario usuario) {
        if (usuario.getEmprestimos().size() >= usuario.getLimite_livros() && usuario.getLimite_livros() != 0) {
            System.out.println("* Usuário atingiu o limite de empréstimos");
            return true;
        }

        return false;
    }

    private boolean livrosEmAtraso(Usuario usuario) {
        for (Emprestimo emprestimo: usuario.getEmprestimos()) {
            if (new Date().after(emprestimo.getData_devolucao()) && emprestimo.getStatus() == Status.EM_ANDAMENTO) {
                System.out.println("* Usuário possui empréstimos em atraso");
                return true;
            }
        }

        return false;
    }
}
