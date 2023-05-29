package by.mkrs.testApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "catalog_waste_classification")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog_WasteClassification implements Serializable {

    @Id
//    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_waste_classification")
    private Long idWasteClassification;

    @Column(name = "kod_waste_classification")
    private String kodWasteClassification;

    @Column(name = "title_waste_classification")
    private String titleWasteClassification;

    @ManyToOne
    @JoinColumn(name = "id_degree_of_danger")
    private Catalog_DegreeOfDanger catalog_degreeOfDanger;

    @ManyToOne
    @JoinColumn(name = "id_class_of_danger")
    private Catalog_ClassOfDanger catalog_classOfDanger;

    @ManyToOne
    @JoinColumn(name = "id_kind_of_activity")
    private Catalog_KindOfActivity catalog_kindOfActivity;

    @Column(name = "education_standard_catalog_waste_classification")
    private String educationStandardCatalogWasteClassification;

}
