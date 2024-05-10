package com.jhon.backend.users.infraestructure.repository.dto;

import com.jhon.backend.users.domain.entity.TypeDocument;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "middleName", nullable = true)
    private String middleName;

    @Column(name = "firstLastName", nullable = false)
    private String firstLastName;

    @Column(name = "secondLastName", nullable = true)
    private String secondLastName;

    @Column(name = "phone", nullable = false)
    private long phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "cityResidence", nullable = false)
    private String cityResidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeDocument", nullable = false)
    private TypeDocument typeDocument;

    @Column(name = "documentNumber", nullable = false)
    private String documentNumber;
}
