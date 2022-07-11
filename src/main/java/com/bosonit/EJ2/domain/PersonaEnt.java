package com.bosonit.EJ2.domain;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Personas")
public class PersonaEnt {

    @Id
    @GeneratedValue
    private Integer id_persona;

    @Column(name="Usuario")
    @NotNull
    private String usuario;

    @Column(name="Password")
    @NotNull
    private Integer password;

    @Column(name="Nombre")
    @NotNull
    private String name;

    @Column(name="Apellidos")
    private String surname;

    @Column(name="Email_empresa")
    @NotNull
    private String company_email;

    @Column(name="Email_personal")
    @NotNull
    private String persona_email;

    @Column(name="Ciudad")
    @NotNull
    private String city;

    @Column(name="Activo")
    @NotNull
    private Boolean active;

    @Column(name="Fecha_creado")
    @NotNull
    private Date created_date;

    @Column(name="Imagen")
    private String imagen_url;

    @Column(name="Fecha_fin")
    private Date termination_date;

}
