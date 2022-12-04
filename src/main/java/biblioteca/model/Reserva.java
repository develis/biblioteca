package biblioteca.model;

import java.util.Date;

public class Reserva {
    private Exemplar exemplar;
    private Long id_usuario;
    private Status status;

    private Date data_reserva;

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(final Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(final Exemplar exemplar) {
        this.exemplar = exemplar;
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
