package br.com.tech4me.crudtech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.crudtech4music.shared.MusicaDto;
import br.com.tech4me.crudtech4music.model.Musica;
import br.com.tech4me.crudtech4music.repository.MusicaRepository;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repositorio;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MusicaDto criarMusica(MusicaDto proddto) {

        Musica p = mapper.map(proddto, Musica.class);
        p = repositorio.save(p);
        MusicaDto dto = mapper.map(p, MusicaDto.class);

        return dto;        
    }

    @Override
    public List<MusicaDto> obterTodos() {
        List<Musica> prod = repositorio.findAll();
        List<MusicaDto> proddto = 
        prod.
        stream().
        map(p -> mapper.map(p, MusicaDto.class)).
        collect(Collectors.toList());

        return proddto;
    }

    @Override
    public Optional <MusicaDto> obterMusicaPorId(String id) {
        Optional<Musica> optprod = repositorio.findById(id);

        if (optprod.isPresent()) {
            MusicaDto proddto = mapper.map(optprod.get(), MusicaDto.class);
            return Optional.of(proddto);
        }

        return Optional.empty();
    }

    @Override
    public Musica atualizarMusica(String id, Musica musica) {
        musica.setId(id);
        return repositorio.save(musica);

        //sem o id do musica
        //método save - criar do zero o musica passado por parametro

        //com o id do musica
        //método save - sobrescreve os campos que mudaram do musica cujo ID é igual id
    }

    @Override
    public void excluirMusica(String id) {
        repositorio.deleteById(id);
        
    }    
}
