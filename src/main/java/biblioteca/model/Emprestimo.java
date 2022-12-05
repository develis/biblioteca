package biblioteca.model;

import java.time.OffsetDateTime;
import java.util.Date;

public class Emprestimo {
    private Long id_usuario;
    private Exemplar exemplar;
    private Date data_devolucao;
    private Date data_emprestimo;
    private Status status;

    public Emprestimo(final Long id_usuario, final Exemplar exemplar, final Date data_emprestimo) {
        this.id_usuario = id_usuario;
        this.exemplar = exemplar;
        this.data_emprestimo = data_emprestimo;
        this.status = Status.EM_ANDAMENTO;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(final Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(final Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(final Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(final Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
