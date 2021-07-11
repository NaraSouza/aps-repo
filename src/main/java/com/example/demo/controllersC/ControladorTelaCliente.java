package com.example.demo.controllersC;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.cliente.Cliente;
import com.example.demo.endereco.Endereco;
import com.example.demo.fachada.Fachada;

import com.example.demo.pedido.Pedido;
import com.example.demo.avaliacao.Avaliacao;
import com.example.demo.restaurante.FilaPedidos;
import com.example.demo.restaurante.Restaurante;
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
        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, endereco , senha, email);
        fachada.cadastrar(cliente, endereco);
        return "redirect:/avaliarPedido";
    }

    @GetMapping("/avaliarPedido")
    public String getPedidos(Model model) {
        return "avaliarPedido";
    }

    @GetMapping("/avaliarPedido/avaliar")
    public String avaliarPedido(@RequestParam Map<String,String> requestParams){
        String nota = requestParams.get("nota");
        String comentario = requestParams.get("comentario");
        Pedido pedido = new Pedido(idCounter.getAndIncrement());
        FilaPedidos filaPedidos = new FilaPedidos();
        Avaliacao avaliacao = new Avaliacao(Double.parseDouble(nota), comentario);
        Restaurante restaurante = new Restaurante(idCounter.getAndIncrement());
        fachada.avaliarPedido(pedido, restaurante, avaliacao);
        return "redirect:/avaliarPedido";
    }

}