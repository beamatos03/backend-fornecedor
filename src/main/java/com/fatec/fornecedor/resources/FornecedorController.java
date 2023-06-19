package com.fatec.fornecedor.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.fatec.fornecedor.entities.Fornecedor;

public class FornecedorController {

@GetMapping("fornecedor")
public Fornecedor getFornecedor(){
    Fornecedor f1 = new Fornecedor(1,"Borracharia","Internacional","info@gmail.com",false);

    return f1;
}

@GetMapping("fornecedores")
public List<Fornecedor> getFornecedores(){
    List <Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    return fornecedores;
}

}
