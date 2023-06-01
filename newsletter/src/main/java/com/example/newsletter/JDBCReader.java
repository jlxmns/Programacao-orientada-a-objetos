package com.example.newsletter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

//Essa classe é responsável pelos métodos do nosso CRUD
public class JDBCReader {

    //precisamos de uma variável do tipo Connection para abrir e fechar a conexão com o BD
    Connection connection;

    public JDBCReader(Connection connection) {
        this.connection = connection;
    }

    //essa função adiciona um novo leitor na nossa tabela de leitores
    public void addReader(Reader r) {
        //as interrogações são elementos que serão definidos
        String sql = "insert into reader(name, email, birthDate) values (?, ?, ?)";
        //prepared statement é uma classe utilizada para segurança (evitar SQL Injection) e permite que façamos SQL queries
        PreparedStatement ps;

        try {
            ps = this.connection.prepareStatement(sql);
            //cada um desses parâmetros substituirá a interrogação equivalente na String sql
            ps.setString(1, r.getName());
            ps.setString(2, r.getEmail());
            ps.setObject(3, r.getBirthDate());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //essa função lista todos os leitores
    public ObservableList<Reader> listReaders() {
        ObservableList<Reader> readers = FXCollections.observableArrayList();
        String sql = "select * from reader";

        try {
            //Statement permite a realização de SQL queries
            Statement declaration = connection.createStatement();
            //ResultSet é uma tabela de dados armazenados por essa consulta
            ResultSet results = declaration.executeQuery(sql);

            //Loop que executa até results não ter mais elementos, cria um novo Reader com as propriedades obtidas dos results e adiciona esse Reader em uma ArrayList
            while(results.next()) {

                int id = results.getInt("id");
                String name = results.getString("name");
                String email = results.getString("email");
                LocalDate birthDate = results.getObject("birthDate", LocalDate.class);

                Reader r = new Reader(id, name, email, birthDate);
                readers.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    //essa função deleta tudo da nossa tabela de leitores
    public void deleteEverything() {
        String sql = "delete from reader";
        PreparedStatement ps;

        try {
            ps = this.connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
