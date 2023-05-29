package by.mkrs.testApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog_WasteClassificationDto implements Serializable {

    private Long idWasteClassification;
    private String kodWasteClassification;
    private String titleWasteClassification;
    private Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto;
    private Catalog_ClassOfDangerDto catalog_classOfDangerDto;
    private Catalog_KindOfActivityDto catalog_kindOfActivityDto;
    private String educationStandardWasteClassification;
}
