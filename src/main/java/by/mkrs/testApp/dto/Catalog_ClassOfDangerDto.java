package by.mkrs.testApp.dto;


import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog_ClassOfDangerDto implements Serializable {

    private Long idClassOfDanger;
    private String titleClassOfDanger;

}
