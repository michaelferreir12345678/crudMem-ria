package br.com.mferreira.dao;

import br.com.mferreira.domain.Cliente;

import java.util.Collection;
import java.util.Collections;

public interface IClienteDAO {

    public Boolean cadatrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar (Long cpf);
    public Collection<Cliente> buscarTodos();
}
