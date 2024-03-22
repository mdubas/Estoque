package com.uninter.estoque.bo;

import com.uninter.estoque.model.Cliente;
import com.uninter.estoque.model.Sexo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest //Informar que a classe é um teste
@ExtendWith(SpringExtension.class) //junit dentro do ambiente Spring
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //order de execução
public class ClienteBOTest {

    @Autowired
    private  ClienteBO bo;

    @Test
    @Order(1)
    public void insere(){
        Cliente cliente = new Cliente();
        cliente.setNome("José da Silva Brasílio");
        cliente.setCpf("01234567890");
        cliente.setDataDeNascimento(LocalDate.of(2000,1,8));
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setTelefone("0123456789");
        cliente.setCelular("01234567890");
        cliente.setAtivo(true);
        bo.insere(cliente);
    }

    @Test
    @Order(2)
    public void pesquisaPeloId(){
        Cliente cliente = bo.pesquisaPeloId(1L);
    }

    @Test
    @Order(3)
    public void atualiza(){
        Cliente cliente = bo.pesquisaPeloId(1L);
        cliente.setSexo(Sexo.FEMININO);
        bo.atualiza(cliente);
    }
}
