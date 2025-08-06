package pe.edu.idat.app_rest_security.services;

import org.springframework.stereotype.Service;
import pe.edu.idat.app_rest_security.model.Especialidad;
import pe.edu.idat.app_rest_security.repository.EspecialidadRepository;
import java.util.List;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> especialidadList(){
        return especialidadRepository.findAll();
    }
    public Especialidad especialidadById(Integer id){
        return especialidadRepository.findById(id).orElse(null);
    }
    public Especialidad saveEspecialidad(
            Especialidad especialidad){
        return especialidadRepository.save(especialidad);
    }
}
