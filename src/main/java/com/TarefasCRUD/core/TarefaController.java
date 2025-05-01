package com.TarefasCRUD.core;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefas")
public class TarefaController { 
    
    public TarefaRepository tarefaRepo;
    
    public TarefaController(TarefaRepository tarefaRepo){
        super();
        this.tarefaRepo = tarefaRepo;
    }
    
    @GetMapping
    public List<Tarefa> getTarefa() {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas = tarefaRepo.findAll();
        return tarefas;
    }
    
    @PostMapping
    public ResponseEntity<Tarefa> addTarefa(@RequestBody Tarefa tarefa) {
        try{
            tarefaRepo.save(tarefa);
            return new ResponseEntity<Tarefa>(tarefa, HttpStatus.CREATED);
        } catch(Error e){
            return null;
        }
    }

    @PutMapping("/{id}")
    public String updateTarefa(@PathVariable int id, @RequestBody Tarefa tarefa){
        return "Tarefa atualizada com Sucesso";
    }

    @DeleteMapping("/{id}")
    public String deleteTarefa(@PathVariable int id){
        return "Tarefa deletada com sucesso";
    }
}