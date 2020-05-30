package br.edu.usj.ads.lp2.cadastro;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OperaRepo extends CrudRepository<OperaString, Long> {
    List<OperaString> findAll();
}