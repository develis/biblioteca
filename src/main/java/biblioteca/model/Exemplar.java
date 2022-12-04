package biblioteca.model;

public class Exemplar {
    private Long id;
    private Long id_livro;
    private String titulo;
    private boolean emprestado;

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(final Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(final boolean emprestado) {
        this.emprestado = emprestado;
    }
}
