package med.delarosa.api.controller;

import jakarta.validation.Valid;
import med.delarosa.api.medico.DatosRegistroMedico;
import med.delarosa.api.medico.Medico;
import med.delarosa.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public List<Medico> listadoMedicos(){

        return medicoRepository.findAll();

    }

}
