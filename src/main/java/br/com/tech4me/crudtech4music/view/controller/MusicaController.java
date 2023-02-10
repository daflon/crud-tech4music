package br.com.tech4me.crudtech4music.view.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.crudtech4music.shared.MusicaDto;
import br.com.tech4me.crudtech4music.model.Musica;
import br.com.tech4me.crudtech4music.service.MusicaService;
import br.com.tech4me.crudtech4music.view.model.MusicaRequest;
import br.com.tech4me.crudtech4music.view.model.MusicaResponse;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    private MusicaService servico;

    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<MusicaResponse>> obterTodos() {
        List<MusicaDto> proddto = servico.obterTodos();
        List<MusicaResponse> prodresponse = 
        proddto.
        stream().
        map(p -> mapper.map(p, MusicaResponse.class)).
        collect(Collectors.toList());

        return new ResponseEntity<>(prodresponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> criarMusica(@RequestBody @Valid MusicaRequest prodrequest) {
        MusicaDto dtorequest = mapper.map(prodrequest, MusicaDto.class);
        MusicaDto dtoresponse = servico.criarMusica(dtorequest);
        MusicaResponse prodresponse = mapper.map(dtoresponse, MusicaResponse.class);

        return new ResponseEntity<>(prodresponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id) {
        Optional<MusicaDto> proddto = servico.obterMusicaPorId(id);

        if(proddto.isPresent()) {
            MusicaResponse prodresponse = mapper.map(proddto.get(), MusicaResponse.class);
            return new ResponseEntity<>(prodresponse, HttpStatus.FOUND);    
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public Musica atuaMusica(@PathVariable String id, @RequestBody Musica musica) {
        return servico.atualizarMusica(id, musica);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> excluirMusica (@PathVariable String id) {
        servico.excluirMusica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        //generic type só aceita variáveis de referência - começam com maiusculo
        //int
        //Integer
    }

}

