package com.TarefasCRUD.core;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefas")
public class TarefaController { 
    
    public final TarefaRepository repo;
    
    public TarefaController(TarefaRepository repo){
        super();
        this.repo = repo;
    }
    
    @GetMapping
    public List<Tarefa> listTarefas() {
        return repo.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa addTarefa(@RequestBody Tarefa tarefa) {
        if(tarefa.getTitulo() == null || tarefa.getTitulo().isEmpty() 
        || tarefa.getDescricao() == null || tarefa.getDescricao().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os campos \"Titulo\" e \"Descricao\" devem ser preenchidos.");
        } else {
            return repo.save(tarefa);
        }
    }

    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable int id, @RequestBody Tarefa novaTarefa){
        return repo.findById(id).map(tarefa -> {
                if(novaTarefa.getTitulo() != null) {tarefa.setTitulo(novaTarefa.getTitulo());}
                if(novaTarefa.getDescricao() != null) {tarefa.setDescricao(novaTarefa.getDescricao());}
                return repo.save(tarefa);
            }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma tarefa com id " + id + " foi encontrada."));
    }

    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma tarefa com id " + id + " foi encontrada.");
        }
    }
}