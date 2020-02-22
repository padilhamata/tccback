package com.pizza.backpizza.models;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TB_Cadastro")
public class Cadastro implements Serializable {
    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String nome;
    private String sobrenome;
    private  String cpf;
    private String telefone;
    @Column(unique = true)
    private  String email;
    @Column(unique = true)
    private String senha;


}
