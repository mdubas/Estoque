package com.uninter.estoque.Controller;

import com.uninter.estoque.BO.ClienteBO;
import com.uninter.estoque.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteBO bo;


    //exibe o formulário sempre que for realizado uma requisição na url indicada
    @RequestMapping(value= "/novo", method = RequestMethod.GET)
    public ModelAndView novo(ModelMap model){
        model.addAttribute("cliente", new Cliente());
        return new ModelAndView("/cliente/formulario", model);
    }


    //@ModelAttribute pega os dados do formulário e monta um objeto do tipo Cliente
    //Thymeleaf vai criar um objeto chamado 'cliente', e apartir desse objeto irá montar os dados que vieram do formulário
    //pode usar o retorno em ModelAndView também, como acima. Funciona também o retorno como String.
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@ModelAttribute Cliente cliente){
        bo.insere(cliente);
        return "/cliente/formulario";
    }
}
