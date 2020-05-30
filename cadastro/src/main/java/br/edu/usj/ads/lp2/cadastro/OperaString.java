package br.edu.usj.ads.lp2.cadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OperaString {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String operacaosString;

}