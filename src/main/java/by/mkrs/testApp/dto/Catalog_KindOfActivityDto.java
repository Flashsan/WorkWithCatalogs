package by.mkrs.testApp.dto;


import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog_KindOfActivityDto implements Serializable {

    private Long idKindOfDanger;
    private String titleKindOfActivity;

}
