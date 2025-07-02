package com.boutique.rachel.boutique_system.service;

import com.boutique.rachel.boutique_system.model.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final List<Pedido> pedidosTemporales;
    private int siguienteId;

    public PedidoService() {
        // Inicializar pedidos de prueba
        this.pedidosTemporales = crearPedidosDePrueba();
        this.siguienteId = pedidosTemporales.size() + 1;
    }

    // ================================
    // MÉTODOS BÁSICOS CRUD (SIN BD)
    // ================================

    public List<Pedido> findAll() {
        return new ArrayList<>(pedidosTemporales);
    }

    public Optional<Pedido> findById(Integer id) {
        return pedidosTemporales.stream()
                .filter(p -> p.getPedId().equals(id))
                .findFirst();
    }

    public Pedido save(Pedido pedido) {
        if (pedido.getPedId() == null) {
            // Crear nuevo pedido
            pedido.setPedId(siguienteId++);
            pedido.setPedFecha(LocalDateTime.now());
            pedido.setPedEstado("PENDIENTE");
            pedidosTemporales.add(pedido);
        } else {
            // Actualizar existente
            pedidosTemporales.removeIf(p -> p.getPedId().equals(pedido.getPedId()));
            pedidosTemporales.add(pedido);
        }
        return pedido;
    }

    public void deleteById(Integer id) {
        pedidosTemporales.removeIf(p -> p.getPedId().equals(id));
    }

    // ================================
    // DATOS DE PRUEBA
    // ================================

    private List<Pedido> crearPedidosDePrueba() {
        List<Pedido> lista = new ArrayList<>();

        // Pedido 1
        Pedido p1 = new Pedido(
                new BigDecimal("150.00"),  // pedTotal
                "Calle Falsa 123",         // pedDireccionEntrega
                "DHL",                     // pedMetodoEnvio
                1,                          // clienteUsuarioUsuId (usuId)
                1                           // facturaFacId
        );
        p1.setPedId(1);
        p1.setPedFecha(LocalDateTime.now().minusDays(2));
        lista.add(p1);

        // Pedido 2
        Pedido p2 = new Pedido(
                new BigDecimal("250.50"),
                "Av. Siempre Viva 742",
                "FedEx",
                2,
                1
        );
        p2.setPedId(2);
        p2.setPedFecha(LocalDateTime.now().minusDays(1));
        lista.add(p2);

        return lista;
    }
}

