package br.edu.usj.ads.lp2.calculadora;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OperaRepo extends CrudRepository<Operacao, Long> {
    List<Operacao> findAll();
}