package by.mkrs.testApp.service.impl;


import by.mkrs.testApp.converter.MapperConfiguration;
import by.mkrs.testApp.converter.impl.Catalog_ClassOfDangerConverter;
import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.repository.Catalog_ClassOfDangerRepository;
import by.mkrs.testApp.service.Catalog_ClassOfDangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  Catalog_ClassOfDangerServiceImpl
        implements Catalog_ClassOfDangerService {

    private final Catalog_ClassOfDangerRepository catalog_classOfDangerRepository;

    private final Catalog_ClassOfDangerConverter catalog_classOfDangerConverter;

    @Override
    public List<Catalog_ClassOfDangerDto> listAll() {
        List<Catalog_ClassOfDanger> catalog_classOfDangerList = catalog_classOfDangerRepository.findAll();
        return MapperConfiguration.convertList(catalog_classOfDangerList, catalog_classOfDangerConverter::entityToDto);
    }

    @Override
    public Page<Catalog_ClassOfDanger> findPaginated(int pageNumber,
                                                      int pageSize,
                                                      String sortField,
                                                      String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,sort);
        return catalog_classOfDangerRepository.findAll(pageable);
    }

    @Override
    public Catalog_ClassOfDangerDto findById(Long catalog_classOfDangerId) {
        return catalog_classOfDangerConverter.entityToDto(catalog_classOfDangerRepository.findById(catalog_classOfDangerId).orElse(null));
    }

    @Override
    public void addNew(Catalog_ClassOfDangerDto catalog_classOfDangerDto) {
        catalog_classOfDangerRepository.save(catalog_classOfDangerConverter.dtoToEntity(catalog_classOfDangerDto));
    }

    @Override
    public void deleteById(Long catalog_classOfDangerId) {
        catalog_classOfDangerRepository.deleteById(catalog_classOfDangerId);
    }

}
