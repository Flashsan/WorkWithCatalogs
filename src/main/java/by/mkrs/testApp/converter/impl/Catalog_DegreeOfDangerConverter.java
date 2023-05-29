package by.mkrs.testApp.converter.impl;

import by.mkrs.testApp.converter.Converter;
import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Catalog_DegreeOfDangerConverter implements Converter<Catalog_DegreeOfDanger, Catalog_DegreeOfDangerDto> {

    private final ModelMapper modelMapper;

    @Override
    public Catalog_DegreeOfDangerDto entityToDto(Catalog_DegreeOfDanger entity) {
        Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto = modelMapper.map(entity, Catalog_DegreeOfDangerDto.class);
        return catalog_degreeOfDangerDto;
    }


    @Override
    public Catalog_DegreeOfDanger dtoToEntity(Catalog_DegreeOfDangerDto dto) {
        Catalog_DegreeOfDanger catalog_degreeOfDanger = modelMapper.map(dto, Catalog_DegreeOfDanger.class);
        return catalog_degreeOfDanger;
    }


}
