package by.mkrs.testApp.service.impl;


import by.mkrs.testApp.converter.MapperConfiguration;
import by.mkrs.testApp.converter.impl.Catalog_KindOfActivityConverter;
import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import by.mkrs.testApp.repository.Catalog_KindOfActivityRepository;
import by.mkrs.testApp.service.Catalog_KindOfActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Catalog_KindOfActivityServiceImpl
        implements Catalog_KindOfActivityService {

    private final Catalog_KindOfActivityRepository catalog_kindOfActivityRepository;

    private final Catalog_KindOfActivityConverter catalog_kindOfActivityConverter;

    @Override
    public List<Catalog_KindOfActivityDto> listAll() {
        List<Catalog_KindOfActivity> catalog_kindOfActivityList = catalog_kindOfActivityRepository.findAll();
        return MapperConfiguration.convertList(catalog_kindOfActivityList, catalog_kindOfActivityConverter::entityToDto);
    }

    @Override
    public Catalog_KindOfActivityDto findById(Long kindOfActivityId) {
        return catalog_kindOfActivityConverter.entityToDto(catalog_kindOfActivityRepository.findById(kindOfActivityId).orElse(null));
    }

    @Override
    public void addNew(Catalog_KindOfActivityDto catalog_kindOfActivityDto) {
        catalog_kindOfActivityRepository.save(catalog_kindOfActivityConverter.dtoToEntity(catalog_kindOfActivityDto));
    }

    @Override
    public void deleteById(Long kindOfActivityId) {
        catalog_kindOfActivityRepository.deleteById(kindOfActivityId);
    }

    @Override
    public Page<Catalog_KindOfActivity> findPaginated(int pageNumber,
                                                         int pageSize,
                                                         String sortField,
                                                         String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,sort);

        return catalog_kindOfActivityRepository.findAll(pageable);
    }
}
