package com.uninter.estoque.DAO;

import com.uninter.estoque.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

//semelhante ao repository, atua implementando a lógica de acesso aos dados, separando as regras de negócio das regras de acesso ao banco de dados.
@Repository
public class ClienteDAO implements CRUD<Cliente, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Cliente pesquisaPeloId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> lista() {
        Query query = entityManager.createQuery("Select c from Cliente c"); // cria uma consulta JPQL (Java Persistence Query Language)
        return (List<Cliente>) query.getResultList(); //convertendo os dados para uma lista de Clientes
    }

    @Override
    public void insere(Cliente cliente) {
        entityManager.persist(cliente);

    }

    @Override
    public void atualiza(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        entityManager.remove(cliente);
    }
}
