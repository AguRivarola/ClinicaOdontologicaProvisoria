package com.dh.clinicaFinal.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    @Setter(AccessLevel.NONE)
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
