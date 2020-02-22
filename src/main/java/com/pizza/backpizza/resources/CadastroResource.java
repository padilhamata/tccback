package com.pizza.backpizza.resources;

import com.pizza.backpizza.models.Cadastro;
import com.pizza.backpizza.repository.CadastroRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/cadastro")
@CrossOrigin
public class CadastroResource {

    @Autowired
    CadastroRepository cadastroRepository;




    @GetMapping
    public List<Cadastro> listaCadastro() {
        return cadastroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cadastro listaCadastroUnico(@PathVariable(value = "id") long id) {
        return cadastroRepository.findById(id);
    }


    @PostMapping
    public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {

        return cadastroRepository.save(cadastro);
    }

    @DeleteMapping("/{id}")
    
    public void deletaCadastro(@PathVariable(value = "id") long id) {

        cadastroRepository.deleteById(id);
    }

    @PutMapping


    public Cadastro atualizaCadastro(@RequestBody Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }


    @PostMapping("/logon")
    public void validaCadastro(@RequestBody Cadastro cadastro){
        var cpf = cadastro.getCpf();
        var senha = cadastro.getSenha();
        List<Cadastro> lista =  cadastroRepository.validaCadastro(cpf,senha);
        if(lista.size()==0){
            System.out.println("so tem 1");
        }else {
            System.out.println("mais que um");
        }

    }

}
