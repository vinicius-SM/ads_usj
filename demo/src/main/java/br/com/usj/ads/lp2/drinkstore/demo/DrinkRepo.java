package br.com.usj.ads.lp2.drinkstore.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DrinkRepo extends CrudRepository <Drink, Long>{
    List<Drink> findAll();
}