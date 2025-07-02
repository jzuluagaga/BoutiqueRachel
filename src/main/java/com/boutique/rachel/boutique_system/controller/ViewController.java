package com.boutique.rachel.boutique_system.controller;

import com.boutique.rachel.boutique_system.model.Usuario;
import com.boutique.rachel.boutique_system.service.PedidoService;
import com.boutique.rachel.boutique_system.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final UsuarioService usuarioService;
    private final PedidoService pedidoService;

    @Autowired
    public ViewController(UsuarioService usuarioService,
                          PedidoService pedidoService) {
        this.usuarioService = usuarioService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Nombre para saludo
        String usuarioNombre = usuarioService.findAll().stream()
                .findFirst()
                .map(Usuario::getNombreCompleto)
                .orElse("Administradora");

        // Ejemplo de métricas fijas
        long totalVentas = 2450000;
        long totalProductos = 1247;
        long bajosStock = 23;
        long pedidosOnline = pedidoService.findAll().size();

        model.addAttribute("usuario", usuarioNombre);
        model.addAttribute("totalVentas", totalVentas);
        model.addAttribute("totalProductos", totalProductos);
        model.addAttribute("bajosStock", bajosStock);
        model.addAttribute("pedidosOnline", pedidosOnline);

        return "dashboard";
    }

    @GetMapping("/usuarios")
    public String usuariosPage(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("totalUsuarios", usuarioService.countAllUsers());
        model.addAttribute("usuariosActivos", usuarioService.countActiveUsers());
        model.addAttribute("usuariosOnline", 0);
        return "usuarios";
    }

    @GetMapping("/pedidos")
    public String pedidosPage(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedidos";
    }

    @GetMapping("/inventario")
    public String inventario() {
        return "inventario";
    }

    @GetMapping("/facturacion")
    public String facturacion() {
        return "facturacion";
    }

    @GetMapping("/ecommerce")
    public String ecommerce() {
        return "ecommerce";
    }

    @GetMapping("/tienda")
    public String tienda() {
        return "tienda";
    }
}



