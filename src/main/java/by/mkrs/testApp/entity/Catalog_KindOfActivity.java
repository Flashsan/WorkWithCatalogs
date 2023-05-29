package by.mkrs.testApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "catalog_kind_of_activity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Catalog_KindOfActivity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kind_of_activity")
    private Long idKindOfDanger;

    @Column(name = "title_kind_of_activity")
    private String titleKindOfActivity;
}
