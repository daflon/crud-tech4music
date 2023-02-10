package br.com.tech4me.crudtech4music.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaRequest {

    private String artista;
    @NotBlank(message = "O nome do album não pode ter caracteres em branco")
    @NotEmpty(message = "O nome do album não pode ser vazio")
    @Size(min = 5, max= 10, message = "O nome do album deve ter no minimo 5 e no maximo 10 caracteres")
    private String album;
    private String genero;
    private int anoLancamento;
    private String compositor;

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }        
    
}
