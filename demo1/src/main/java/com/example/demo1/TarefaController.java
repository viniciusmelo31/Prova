package com.example.demo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Tarefa")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping("/")
    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    @GetMapping("/{id}")
    public Tarefa encontrarTarefaPorId(@PathVariable int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }

    @PostMapping("/")
    public Tarefa adicionarTarefa(@RequestBody Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefa;
    }

    @PutMapping("/{id}")
    public Tarefa editarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaAtualizado) {
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            if (tarefa.getId() == id) {
                tarefas.set(i, tarefaAtualizado);
                return tarefaAtualizado;
            }
        }
        return null;
    }
}


