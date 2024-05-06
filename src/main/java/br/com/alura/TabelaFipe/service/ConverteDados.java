package br.com.alura.TabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IconverteDados{
    // por usar o jackson para converter os dados para json usamos a classe
    // object mapper.
    private ObjectMapper mapper = new ObjectMapper();

    @Override  //Retorna apenas a resposta genérica do que foi pedido
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override  //Retorna uma lista genérica de qualquer tipo de dado que for a resposta
    public <T> List<T> obterLista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        try {
            return mapper.readValue(json,lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
