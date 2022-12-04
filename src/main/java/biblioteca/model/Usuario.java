package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private Integer tempo_emprestimo;
    private Integer limite_livros;

    private Hierarquia hierarquia;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Devolucao> devolucoes = new ArrayList<>();

    public Usuario(final Long id, final String nome, final Integer tempo_emprestimo, final Integer limite_livros, Hierarquia hierarquia) {
        this.id = id;
        this.nome = nome;
        this.tempo_emprestimo = tempo_emprestimo;
        this.limite_livros = limite_livros;
        this.hierarquia = hierarquia;
    }

    public Integer getLimite_livros() {
        return limite_livros;
    }

    public void setLimite_livros(final Integer limite_livros) {
        this.limite_livros = limite_livros;
    }

    public Hierarquia getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(final Hierarquia hierarquia) {
        this.hierarquia = hierarquia;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Integer getTempo_emprestimo() {
        return tempo_emprestimo;
    }

    public void setTempo_emprestimo(final Integer tempo_emprestimo) {
        this.tempo_emprestimo = tempo_emprestimo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(final List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(final List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Devolucao> getDevolucoes() {
        return devolucoes;
    }

    public void setDevolucoes(final List<Devolucao> devolucoes) {
        this.devolucoes = devolucoes;
    }

    public void addReserva(final Reserva reserva) {
        reservas.add(reserva);
    }

    public void addEmprestimo(final Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addDevolucao(final Devolucao devolucao) {
        devolucoes.add(devolucao);
    }
}
