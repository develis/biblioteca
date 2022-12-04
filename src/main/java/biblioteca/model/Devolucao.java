package biblioteca.model;

import java.util.Date;

public class Devolucao {
    private Long id_usuario;
    private Status status;

    private Exemplar exemplar;

    private Date data_devolucao;

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(final Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(final Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(final Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }
}
