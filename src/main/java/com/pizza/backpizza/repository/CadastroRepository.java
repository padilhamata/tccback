package com.pizza.backpizza.repository;

import com.pizza.backpizza.models.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    Cadastro findById(long id);

    @Query("SELECT validacao FROM Cadastro validacao WHERE validacao.email = :email AND validacao.senha = :senha")
    List<Cadastro> validaCadastro(@Param("email")String email, @Param("senha") String senha);



}
