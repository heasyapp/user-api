package com.heasyapp.beans;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

    public String nome;
    public String cpf;
    public String data_nasc;
    public String sexo;
    public String email;
    public String celular;
    public boolean profSaude;
    public long crm;
    public String ufCrm;
    public List<String> especialidade;

}
