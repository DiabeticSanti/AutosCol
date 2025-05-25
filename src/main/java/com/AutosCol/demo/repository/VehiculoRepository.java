    package com.AutosCol.demo.repository;

    import com.AutosCol.demo.models.Vehiculo;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Optional;

    @Repository
    public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
        Optional<Vehiculo> findByPlaca(String placa);

        List<Vehiculo> findByPlacaContainingIgnoreCase(String placa);

    }
