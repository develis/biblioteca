package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private Long id;
    private List<Exemplar> exemplares = new ArrayList<>();
    private String titulo;
    private String editora;
    private List<String> autores;

    private Integer edicao;
    private Integer ano_publicacao;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(final List<Exemplar> exemplares) {
        this.exemplares = exemplares;
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

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(final String editora) {
        this.editora = editora;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(final List<String> autores) {
        this.autores = autores;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(final Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(final Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public void addReserva(final Reserva reserva) {
        reservas.add(reserva);
    }

    public void addEmprestimo(final Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
}
