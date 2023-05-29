package by.mkrs.testApp.dto;


import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog_DegreeOfDangerDto implements Serializable {

    private Long idDegreeOfDanger;
    private String titleDegreeOfDanger;

}
