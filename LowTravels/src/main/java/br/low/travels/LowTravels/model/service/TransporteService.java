package br.low.travels.LowTravels.model.service;

import br.low.travels.LowTravels.model.entity.Transporte;
import br.low.travels.LowTravels.repository.TransporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransporteService {
    private TransporteRepository transporteRepository;

    public List<Transporte> findAll() {
        return transporteRepository.findAll();
    }

    public Transporte save(Transporte transporte) {
        return transporteRepository.save(transporte);
    }

    public Optional<Transporte> findById(Integer id) {
        return transporteRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return transporteRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        transporteRepository.deleteById(id);
    }
}
