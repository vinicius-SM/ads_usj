package br.edu.usj.ads.lp2.crudcontatos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepo extends CrudRepository<Contato,Long> {

    List<Contato> findAll();
    
}