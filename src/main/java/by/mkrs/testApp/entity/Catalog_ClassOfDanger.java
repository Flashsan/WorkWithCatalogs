package by.mkrs.testApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "catalog_class_of_danger")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog_ClassOfDanger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class_of_danger")
    private Long idClassOfDanger;

    @Column(name = "title_class_of_danger")
    private String titleClassOfDanger;

}
