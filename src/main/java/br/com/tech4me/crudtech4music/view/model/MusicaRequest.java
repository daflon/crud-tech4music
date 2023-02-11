package br.com.tech4me.crudtech4music.view.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaRequest {

    @NotBlank(message = "O nome do artista não pode ter caracteres em branco")
    @NotEmpty(message = "O nome do artista não pode ser vazio")
    private String artista;
    
    @NotBlank(message = "O nome do album não pode ter caracteres em branco")
    @NotEmpty(message = "O nome do album não pode ser vazio")
    private String album;
    
    @NotBlank(message = "O gênero não pode ter caracteres em branco")
    @NotEmpty(message = "O gênero não pode ser vazio")
    private String genero;
    
    @Digits (fraction = 0, integer = 4, message = "O ano de lançamento deve conter 4 caracteres conforme ex: '1982'")
    private int anoLancamento;
    
    @NotBlank(message = "O nome do compositor não pode ter caracteres em branco")
    @NotEmpty(message = "O nome do compositor não pode ser vazio")
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
