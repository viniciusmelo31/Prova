package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Tarefa1")
public class Tarefa1Controller {

    private List<com.example.demo.Tarefa1> produtos = new ArrayList<>();


    @GetMapping("/")
    public List<com.example.demo.Tarefa1> listarTarefa1() {
        return produtos;
    }

    @GetMapping("/{id}")
    public com.example.demo.Tarefa1 encontrarTarefa1PorId(@PathVariable int id) {
        for (com.example.demo.Tarefa1 produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }


    @PostMapping("/")
    public com.example.demo.Tarefa1 adicionarTarefa1(@RequestBody com.example.demo.Tarefa1 produto) {
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/{id}")
    public com.example.demo.Tarefa1 editarTarefa1(@PathVariable int id, @RequestBody com.example.demo.Tarefa1 tarefaAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            com.example.demo.Tarefa1 produto = produtos.get(i);
            if (produto.getId() == id) {
                produtos.set(i, tarefaAtualizado);
                return tarefaAtualizado;
            }
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void excluirTarefa1(@PathVariable int id) {
        for (com.example.demo.Tarefa1 produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return;
            }
        }
    }
}
