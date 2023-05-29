package by.mkrs.testApp.converter.impl;

import by.mkrs.testApp.converter.Converter;
import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Catalog_ClassOfDangerConverter implements Converter<Catalog_ClassOfDanger, Catalog_ClassOfDangerDto> {

    private final ModelMapper modelMapper;


    @Override
    public Catalog_ClassOfDangerDto entityToDto(Catalog_ClassOfDanger entity) {
        Catalog_ClassOfDangerDto catalog_classOfDangerDto = modelMapper.map(entity, Catalog_ClassOfDangerDto.class);
        return catalog_classOfDangerDto;
    }

    @Override
    public Catalog_ClassOfDanger dtoToEntity(Catalog_ClassOfDangerDto dto) {
        Catalog_ClassOfDanger catalog_classOfDanger = modelMapper.map(dto, Catalog_ClassOfDanger.class);
        return catalog_classOfDanger;
    }


}
