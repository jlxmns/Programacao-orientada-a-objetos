package com.example.newsletter;

import java.time.LocalDate;

/* Essa classe tem o nome da nossa tabela do banco de dados
Cada variável é o nome de uma coluna da nossa tabela
A variável LocalDate é compatível com o DATE do SQL
Definimos nossos getters e setters aqui também, e o construtor da classe.
 */
public class Reader {
    private int id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public Reader() {}

    public Reader(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Reader(int id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
