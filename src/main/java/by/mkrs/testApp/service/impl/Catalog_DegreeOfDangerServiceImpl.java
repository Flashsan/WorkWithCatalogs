package by.mkrs.testApp.service.impl;


import by.mkrs.testApp.converter.MapperConfiguration;
import by.mkrs.testApp.converter.impl.Catalog_DegreeOfDangerConverter;
import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.repository.Catalog_DegreeOfDangerRepository;
import by.mkrs.testApp.service.Catalog_DegreeOfDangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Catalog_DegreeOfDangerServiceImpl
        implements Catalog_DegreeOfDangerService {

    private final Catalog_DegreeOfDangerRepository catalog_degreeOfDangerRepository;

    private final Catalog_DegreeOfDangerConverter catalog_degreeOfDangerConverter;

    @Override
    public List<Catalog_DegreeOfDangerDto> listAll() {
        List<Catalog_DegreeOfDanger> catalog_degreeOfDangerList = catalog_degreeOfDangerRepository.findAll();
        return MapperConfiguration.convertList(catalog_degreeOfDangerList, catalog_degreeOfDangerConverter::entityToDto);
    }

    @Override
    public Catalog_DegreeOfDangerDto findById(Long catalog_degreeOfDangerId) {
        return catalog_degreeOfDangerConverter
                .entityToDto(catalog_degreeOfDangerRepository.findById(catalog_degreeOfDangerId)
                .orElse(null));
    }

    @Override
    public void addNew(Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto) {
        catalog_degreeOfDangerRepository.save(catalog_degreeOfDangerConverter.dtoToEntity(catalog_degreeOfDangerDto));
    }

    @Override
    public void deleteById(Long catalog_degreeOfDangerId) {
        catalog_degreeOfDangerRepository.deleteById(catalog_degreeOfDangerId);
    }

    @Override
    public Page<Catalog_DegreeOfDanger> findPaginated(int pageNumber,
                                                      int pageSize,
                                                      String sortField,
                                                      String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

        return catalog_degreeOfDangerRepository.findAll(pageable);
    }

}
