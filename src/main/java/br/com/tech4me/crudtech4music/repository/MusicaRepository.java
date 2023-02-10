package br.com.tech4me.crudtech4music.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.crudtech4music.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    //ressalva:
    //insert > save
    //find > findAll
    //métodos vão mudar de nome aqui dentro da nossa aplicação
    //porém, vão continuar fazendo a mesma coisa que faziam dentro do Mongo
    //findByBlablabla 
    //@Query() 
}
