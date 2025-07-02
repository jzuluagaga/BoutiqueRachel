package com.boutique.rachel.boutique_system.service;

import com.boutique.rachel.boutique_system.model.Usuario;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class UsuarioService {

    // Lista temporal para simular base de datos
    private List<Usuario> usuariosTemporales;

    public UsuarioService() {
        // Inicializar datos de prueba
        this.usuariosTemporales = crearUsuariosDePrueba();
    }

    // ================================
    // MÉTODOS BÁSICOS CRUD (SIN BD)
    // ================================

    public List<Usuario> findAll() {
        return new ArrayList<>(usuariosTemporales);
    }

    public Optional<Usuario> findById(Integer id) {
        return usuariosTemporales.stream()
                .filter(u -> u.getUsuId().equals(id))
                .findFirst();
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuariosTemporales.stream()
                .filter(u -> u.getUsuEmail().equals(email))
                .findFirst();
    }

    public Usuario save(Usuario usuario) {
        // Simular guardado: asignar ID si es nuevo
        if (usuario.getUsuId() == null) {
            int nextId = usuariosTemporales.size() + 1;
            usuario.setUsuId(nextId);
            usuario.setUsuFechaCreacion(LocalDateTime.now());
            usuariosTemporales.add(usuario);
        } else {
            // Actualizar existente
            usuariosTemporales.removeIf(u -> u.getUsuId().equals(usuario.getUsuId()));
            usuariosTemporales.add(usuario);
        }
        return usuario;
    }

    public void deleteById(Integer id) {
        usuariosTemporales.removeIf(u -> u.getUsuId().equals(id));
    }

    // ================================
    // MÉTODOS DE VALIDACIÓN
    // ================================

    public boolean existsByEmail(String email) {
        return usuariosTemporales.stream()
                .anyMatch(u -> u.getUsuEmail().equals(email));
    }

    public boolean existsByDocumento(String tipoDocumento, String numeroDocumento) {
        return usuariosTemporales.stream()
                .anyMatch(u -> u.getUsuTipoDocumento().equals(tipoDocumento)
                        && u.getUsuNumeroDocumento().equals(numeroDocumento));
    }

    // ================================
    // MÉTODOS DE BÚSQUEDA
    // ================================

    public List<Usuario> findActiveUsers() {
        return usuariosTemporales.stream()
                .filter(u -> u.getUsuEstado() != null && u.getUsuEstado())
                .toList();
    }

    public List<Usuario> findInactiveUsers() {
        return usuariosTemporales.stream()
                .filter(u -> u.getUsuEstado() == null || !u.getUsuEstado())
                .toList();
    }

    public Optional<Usuario> findActiveUserByEmail(String email) {
        return usuariosTemporales.stream()
                .filter(u -> u.getUsuEmail().equals(email) &&
                        u.getUsuEstado() != null && u.getUsuEstado())
                .findFirst();
    }

    // ================================
    // MÉTODOS DE ESTADÍSTICAS
    // ================================

    public long countAllUsers() {
        return usuariosTemporales.size();
    }

    public long countActiveUsers() {
        return findActiveUsers().size();
    }

    // ================================
    // MÉTODOS DE GESTIÓN DE ESTADO
    // ================================

    public Usuario activateUser(Integer id) {
        Optional<Usuario> usuario = findById(id);
        if (usuario.isPresent()) {
            usuario.get().setUsuEstado(true);
            return usuario.get();
        }
        throw new RuntimeException("Usuario no encontrado");
    }

    public Usuario deactivateUser(Integer id) {
        Optional<Usuario> usuario = findById(id);
        if (usuario.isPresent()) {
            usuario.get().setUsuEstado(false);
            return usuario.get();
        }
        throw new RuntimeException("Usuario no encontrado");
    }

    // ================================
    // DATOS DE PRUEBA
    // ================================

    private List<Usuario> crearUsuariosDePrueba() {
        List<Usuario> usuarios = new ArrayList<>();

        // Usuario 1 - Administrador
        Usuario admin = new Usuario();
        admin.setUsuId(1);
        admin.setUsuNombre("Rachel");
        admin.setUsuApellido("Boutique");
        admin.setUsuEmail("admin@boutique.com");
        admin.setUsuPassword("admin123");
        admin.setUsuTipoDocumento("CC");
        admin.setUsuNumeroDocumento("1234567890");
        admin.setUsuTelefono("3001234567");
        admin.setUsuEstado(true);
        admin.setUsuFechaCreacion(LocalDateTime.now().minusDays(30));
        usuarios.add(admin);

        // Usuario 2 - Vendedor
        Usuario vendedor = new Usuario();
        vendedor.setUsuId(2);
        vendedor.setUsuNombre("Ana");
        vendedor.setUsuApellido("García");
        vendedor.setUsuEmail("ana.garcia@boutique.com");
        vendedor.setUsuPassword("vendedor123");
        vendedor.setUsuTipoDocumento("CC");
        vendedor.setUsuNumeroDocumento("9876543210");
        vendedor.setUsuTelefono("3009876543");
        vendedor.setUsuEstado(true);
        vendedor.setUsuFechaCreacion(LocalDateTime.now().minusDays(15));
        usuarios.add(vendedor);

        // Usuario 3 - Cliente
        Usuario cliente = new Usuario();
        cliente.setUsuId(3);
        cliente.setUsuNombre("Carlos");
        cliente.setUsuApellido("López");
        cliente.setUsuEmail("carlos.lopez@gmail.com");
        cliente.setUsuPassword("cliente123");
        cliente.setUsuTipoDocumento("CC");
        cliente.setUsuNumeroDocumento("1122334455");
        cliente.setUsuTelefono("3001122334");
        cliente.setUsuEstado(true);
        cliente.setUsuFechaCreacion(LocalDateTime.now().minusDays(7));
        usuarios.add(cliente);

        // Usuario 4 - Inventarista
        Usuario inventarista = new Usuario();
        inventarista.setUsuId(4);
        inventarista.setUsuNombre("María");
        inventarista.setUsuApellido("Rodríguez");
        inventarista.setUsuEmail("maria.rodriguez@boutique.com");
        inventarista.setUsuPassword("inventario123");
        inventarista.setUsuTipoDocumento("CC");
        inventarista.setUsuNumeroDocumento("5566778899");
        inventarista.setUsuTelefono("3005566778");
        inventarista.setUsuEstado(true);
        inventarista.setUsuFechaCreacion(LocalDateTime.now().minusDays(3));
        usuarios.add(inventarista);

        // Usuario 5 - Usuario inactivo
        Usuario inactivo = new Usuario();
        inactivo.setUsuId(5);
        inactivo.setUsuNombre("Juan");
        inactivo.setUsuApellido("Martínez");
        inactivo.setUsuEmail("juan.martinez@gmail.com");
        inactivo.setUsuPassword("cliente456");
        inactivo.setUsuTipoDocumento("CC");
        inactivo.setUsuNumeroDocumento("9988776655");
        inactivo.setUsuTelefono("3009988776");
        inactivo.setUsuEstado(false); // INACTIVO
        inactivo.setUsuFechaCreacion(LocalDateTime.now().minusDays(45));
        usuarios.add(inactivo);

        return usuarios;
    }
}
