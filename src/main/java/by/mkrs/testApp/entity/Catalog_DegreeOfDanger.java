package by.mkrs.testApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "catalog_degree_of_danger")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog_DegreeOfDanger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_degree_of_danger")
    private Long idDegreeOfDanger;

    @Column(name = "title_degree_of_danger")
    private String titleDegreeOfDanger;

}
