package br.com.usj.ads.lp2.drinkstore.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nome;
    String descricao;
    String fabricante;
    Double teor;
    Double preco;
    
}