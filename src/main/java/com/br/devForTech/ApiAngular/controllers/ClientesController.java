package com.br.devForTech.ApiAngular.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.devForTech.ApiAngular.modelViews.Erro;
import com.br.devForTech.ApiAngular.models.Cliente;

@CrossOrigin("*")
@RestController
public class ClientesController {
    @GetMapping("/clientes.json")
    public List<Cliente> index(){
        return Cliente.todos();
    }

    @PostMapping("/clientes.json")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente){
        cliente.setId(Cliente.todos().size() + 1);

        if(cliente.getNome() == null || cliente.getNome().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O nome é obrigatório"));
        }

        if(cliente.getEmail() == null || cliente.getEmail().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O email é obrigatório"));
        }

        if(cliente.getSenha() == null || cliente.getSenha().isEmpty()){
            return ResponseEntity.status(400).body(new Erro("O senha é obrigatório"));
        }

        Cliente.add(cliente);
        return ResponseEntity.status(200).body(cliente);
    }

    @GetMapping("/clientes/{id}.json")
    public Cliente create(@PathVariable int id){
        var cliente = buscaPorId(id);
        return cliente;
    }

    @DeleteMapping("/clientes/{id}.json")
    public Cliente delete(int id){
        var cliente = buscaPorId(id);
        var clientes = Cliente.todos();
        clientes.remove(cliente);
        Cliente.set(clientes);
        return cliente;
    }

    private Cliente buscaPorId(int id) {
        var cliente = new Cliente();
        for (Cliente c : Cliente.todos()) {
            if(c.equals(id)){
                cliente = c;
                break;
            }
        }

        return cliente;
    }
}
