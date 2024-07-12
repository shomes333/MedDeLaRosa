package med.delarosa.api.controller;

import med.delarosa.api.medico.DatosRegistroMedico;
import med.delarosa.api.medico.Medico;
import med.delarosa.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")

public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

}
