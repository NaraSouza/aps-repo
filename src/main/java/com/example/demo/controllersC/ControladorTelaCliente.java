package com.example.demo.comunicacao;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.negocio.Cliente;
import com.example.demo.negocio.Endereco;
import com.example.demo.negocio.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorTelaCliente {

    @Autowired
    private Fachada fachada;
    private static final AtomicLong idCounter = new AtomicLong();

    @GetMapping("/cliente")
    public String getClientes(Model model) {
        return "clientes";
    }

    @GetMapping("/cliente/criar/")
    public String novoCliente(@RequestParam Map<String,String> requestParams){
        String nome =requestParams.get("nome");
        String senha =requestParams.get("senha");
        String email =requestParams.get("email");
        String rua =requestParams.get("rua");
        String cidade =requestParams.get("cidade");
        String bairro =requestParams.get("bairro");
        String complemento =requestParams.get("complemento");
        String cep =requestParams.get("cep");
        Endereco endereco =  new Endereco(idCounter.getAndIncrement(),rua,cidade,bairro,complemento,cep);
        fachada.inserirEndereco(endereco);
        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, endereco , senha, email);
        fachada.inserirCliente(cliente);
        return "redirect:/cliente";
    }

}