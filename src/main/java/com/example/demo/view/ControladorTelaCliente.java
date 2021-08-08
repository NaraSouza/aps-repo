package com.example.demo.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.cliente.Cliente;
import com.example.demo.endereco.Endereco;
import com.example.demo.fachada.Fachada;

import com.example.demo.pagamento.Pagamento;
import com.example.demo.pedido.Item;
import com.example.demo.pedido.Pedido;
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
        String nome = requestParams.get("nome");
        String senha = requestParams.get("senha");
        String email = requestParams.get("email");
        String rua = requestParams.get("rua");
        String cidade = requestParams.get("cidade");
        String bairro = requestParams.get("bairro");
        String complemento = requestParams.get("complemento");
        String cep = requestParams.get("cep");

        Endereco endereco =  new Endereco(idCounter.getAndIncrement(), rua, cidade, bairro, complemento, cep);

        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, endereco , senha, email);

        fachada.cadastrar(cliente, endereco);

        return "redirect:/cliente";
    }

    @GetMapping("/efetuarPedido")
    public String getRestaurantes(Model model) {
        return "efetuarPedido";
    }

    @GetMapping("/efetuarPedido/preencher")
    public String efetuarPedido(@RequestParam Map<String,String> requestParams){
        String descricao = requestParams.get("itemDescricao");
        String formaPagamento = requestParams.get("formaPagamento");
        String valorPagamento = requestParams.get("valorPagamento");

        Item item = new Item(descricao);
        Pedido pedido = new Pedido(idCounter.getAndIncrement());
        List<Item> itens = new ArrayList<Item>();
        itens.add(item);
        pedido.setItens(itens);
        Pagamento pagamento = new Pagamento(formaPagamento, Double.parseDouble(valorPagamento));
        Restaurante restaurante = new Restaurante(idCounter.getAndIncrement());

        fachada.efetuarPedido(pedido, restaurante, pagamento);

        return "redirect:/efetuarPedido";
    }

}