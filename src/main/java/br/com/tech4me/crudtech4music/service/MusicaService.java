package br.com.tech4me.crudtech4music.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.crudtech4music.shared.MusicaDto;
import br.com.tech4me.crudtech4music.model.Musica;

public interface MusicaService {
    MusicaDto criarMusica(MusicaDto musica);
    List<MusicaDto> obterTodos();
    Optional<MusicaDto> obterMusicaPorId(String id);
    //atualizar
    Musica atualizarMusica(String id, Musica musica);
    //deletar
    void excluirMusica(String id);
}
