package com.fatec.fornecedor.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.fornecedor.entities.Fornecedor;
import com.fatec.fornecedor.services.FornecedorService;

@CrossOrigin
@RequestMapping("fornecedores")
@RestController
public class FornecedorController {

@Autowired
private FornecedorService service;

@GetMapping("{id}")
public ResponseEntity<Fornecedor> getFornecedor(@PathVariable int id){
    Fornecedor fornecedor = service.getFornecedorById(id);
    return ResponseEntity.ok().body(fornecedor);
} 

@GetMapping
public ResponseEntity<List<Fornecedor>> getFornecedores(){
List<Fornecedor> fornecedores = service.getFornecedores();
return ResponseEntity.ok().body(fornecedores);
}

  @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int id){
        service.deletByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editFornecedor(@PathVariable int id, @RequestBody Fornecedor fornecedor){
        service.update(id, fornecedor);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody Fornecedor fornecedor){

        Fornecedor newFornecedor = service.save(fornecedor);
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(fornecedor.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newFornecedor);
    }


}


