package by.mkrs.testApp.converter.impl;

import by.mkrs.testApp.converter.Converter;
import by.mkrs.testApp.dto.Catalog_WasteClassificationDto;
import by.mkrs.testApp.entity.Catalog_WasteClassification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Catalog_WasteClassificationConverter implements Converter<Catalog_WasteClassification, Catalog_WasteClassificationDto> {

    private final ModelMapper modelMapper;

    private final Catalog_DegreeOfDangerConverter catalog_degreeOfDangerConverter;
    private final Catalog_ClassOfDangerConverter catalog_classOfDangerConverter;
    private final Catalog_KindOfActivityConverter catalog_kindOfActivityConverter;


    @Override
    public Catalog_WasteClassificationDto entityToDto(Catalog_WasteClassification entity) {
        Catalog_WasteClassificationDto catalog_wasteClassificationDto = modelMapper.map(entity, Catalog_WasteClassificationDto.class);
        catalog_wasteClassificationDto.setCatalog_degreeOfDangerDto(catalog_degreeOfDangerConverter.entityToDto(entity.getCatalog_degreeOfDanger()));
        catalog_wasteClassificationDto.setCatalog_classOfDangerDto(catalog_classOfDangerConverter.entityToDto(entity.getCatalog_classOfDanger()));
        catalog_wasteClassificationDto.setCatalog_kindOfActivityDto(catalog_kindOfActivityConverter.entityToDto(entity.getCatalog_kindOfActivity()));
        return catalog_wasteClassificationDto;
    }

    @Override
    public Catalog_WasteClassification dtoToEntity(Catalog_WasteClassificationDto dto) {
        Catalog_WasteClassification catalog_wasteClassification = modelMapper.map(dto, Catalog_WasteClassification.class);
        catalog_wasteClassification.setCatalog_degreeOfDanger(catalog_degreeOfDangerConverter.dtoToEntity(dto.getCatalog_degreeOfDangerDto()));
        catalog_wasteClassification.setCatalog_classOfDanger(catalog_classOfDangerConverter.dtoToEntity(dto.getCatalog_classOfDangerDto()));
        catalog_wasteClassification.setCatalog_kindOfActivity(catalog_kindOfActivityConverter.dtoToEntity(dto.getCatalog_kindOfActivityDto()));
        return catalog_wasteClassification;
    }


}


