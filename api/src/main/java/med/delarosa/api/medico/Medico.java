package med.delarosa.api.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.delarosa.api.direccion.Direccion;


@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String documento;
    private Especialidad especialidad;
    private Direccion direccion;

    @Enumerated(EnumType.STRING)
    @Embedded

    public Medico(DatosRegistroMedico datosRegistroMedico) {

        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion (datosRegistroMedico.direccion());

    }
}
