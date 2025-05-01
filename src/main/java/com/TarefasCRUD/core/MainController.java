package com.TarefasCRUD.core;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefas")
public class MainController { 
    List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping
    public List<Tarefa> getTarefa() {
        return tarefas;
    }
    
    @PostMapping
    public String addTarefa(@RequestBody Tarefa tarefa) {
        tarefas.add(tarefa);
        return "Tarefa adicionada com sucesso";
    }

    @PutMapping("/{id}")
    public String updateTarefa(@PathVariable int id, @RequestBody Tarefa tarefa){
        tarefas.add(id, tarefa);
        return "Tarefa atualizada com Sucesso";
    }

    @DeleteMapping("/{id}")
    public String deleteTarefa(@PathVariable int id){
        tarefas.remove(id);
        return "Tarefa deletada com sucesso";
    }
}