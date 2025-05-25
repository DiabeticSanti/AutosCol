package com.AutosCol.demo.services;

import com.AutosCol.demo.models.Pago;
import com.AutosCol.demo.models.Usuario;
import com.AutosCol.demo.models.Vehiculo;
import com.AutosCol.demo.repository.PagoRepository;
import com.AutosCol.demo.repository.UsuarioRepository;
import com.AutosCol.demo.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago guardarPago(Pago pago) {
        Usuario usuario = usuarioRepository.findById(pago.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        Vehiculo vehiculo = vehiculoRepository.findById(pago.getVehiculo().getId())
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        
        pago.setUsuario(usuario);
        pago.setVehiculo(vehiculo);
        
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Long id, Pago detallesPago) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);

        if (pagoOptional.isPresent()) {
            Pago pagoExistente = pagoOptional.get();
            pagoExistente.setMonto(detallesPago.getMonto());
            
            Usuario usuario = usuarioRepository.findById(detallesPago.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            Vehiculo vehiculo = vehiculoRepository.findById(detallesPago.getVehiculo().getId())
                    .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));

            pagoExistente.setUsuario(usuario);
            pagoExistente.setVehiculo(vehiculo);
            
            return pagoRepository.save(pagoExistente);
        } else {
            return null;
        }
    }

    public boolean eliminarPago(Long id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);

        if (pagoOptional.isPresent()) {
            pagoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

