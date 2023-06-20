package com.fatec.fornecedor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fornecedor.entities.Fornecedor;
import com.fatec.fornecedor.repositories.FornecedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService{
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedorById(int id) {
        return fornecedorRepository.findById(id).orElseThrow(()
         -> new EntityNotFoundException("Fornecedor não encontrado"));
        //Neste caso precisamos lançar uma exceção para o caso do usuario tentar buscar por um id que não existe
    }

    public List<Fornecedor> getFornecedores(){
        return fornecedorRepository.findAll();
    }

        public void deletByID(int id) {
        Fornecedor fornecedor = getFornecedorById(id);
        fornecedorRepository.delete(fornecedor);}

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);}

    public void update(int id, Fornecedor fornecedor) {
        getFornecedorById(id);
        fornecedorRepository.save(fornecedor);   }

}