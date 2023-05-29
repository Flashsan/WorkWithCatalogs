package by.mkrs.testApp.converter.impl;

import by.mkrs.testApp.converter.Converter;
import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Catalog_KindOfActivityConverter implements Converter<Catalog_KindOfActivity, Catalog_KindOfActivityDto> {

    private final ModelMapper modelMapper;

    @Override
    public Catalog_KindOfActivityDto entityToDto(Catalog_KindOfActivity entity) {
        Catalog_KindOfActivityDto catalog_kindOfActivityDto = modelMapper.map(entity, Catalog_KindOfActivityDto.class);
        return catalog_kindOfActivityDto;
    }

    @Override
    public Catalog_KindOfActivity dtoToEntity(Catalog_KindOfActivityDto dto) {
        Catalog_KindOfActivity catalog_kindOfActivity = modelMapper.map(dto, Catalog_KindOfActivity.class);
        return catalog_kindOfActivity;
    }


}
