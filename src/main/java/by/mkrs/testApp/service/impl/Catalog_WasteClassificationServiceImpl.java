package by.mkrs.testApp.service.impl;


import by.mkrs.testApp.converter.MapperConfiguration;
import by.mkrs.testApp.converter.impl.Catalog_WasteClassificationConverter;
import by.mkrs.testApp.dto.Catalog_WasteClassificationDto;
import by.mkrs.testApp.entity.Catalog_WasteClassification;
import by.mkrs.testApp.repository.Catalog_WasteClassificationRepository;
import by.mkrs.testApp.service.Catalog_WasteClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Catalog_WasteClassificationServiceImpl
        implements Catalog_WasteClassificationService {

    private final Catalog_WasteClassificationRepository catalog_wasteClassificationRepository;

    private final Catalog_WasteClassificationConverter catalog_wasteClassificationConverter;

    @Override
    public List<Catalog_WasteClassificationDto>  listAll(int pageNumber, int pageSize, String sortField, String sortDirection) {
//        Page<Catalog_WasteClassification> page = findPaginated(pageNumber, pageSize, sortField, sortDirection);
//        page.getTotalElements();
//        page.getTotalPages();
//        List<Catalog_WasteClassification> catalog_wasteClassificationList=page.getContent();
        List<Catalog_WasteClassification> catalog_wasteClassificationList=catalog_wasteClassificationRepository.findAll();
        return MapperConfiguration.convertList(catalog_wasteClassificationList, catalog_wasteClassificationConverter::entityToDto);
    }

   @Override
    public Page<Catalog_WasteClassification> findPaginated(int pageNumber,
                                                      int pageSize,
                                                      String sortField,
                                                      String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Sort sortByField_2 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Sort sortByField_3 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Sort sortByField_4 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Sort sortByField_5 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//        Sort sortByField_6 = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//Sort sort = sortByField_1.by("sortByField_1").ascending()
//        .and(sortByField_2.by("sortByField_2").ascending())
//        .and(sortByField_3.by("sortByField_3").ascending())
//        .and(sortByField_4.by("sortByField_4").ascending())
//        .and(sortByField_5.by("sortByField_5").ascending())
//        .and(sortByField_6.by("sortByField_6").ascending());
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,sort);

        return catalog_wasteClassificationRepository.findAll(pageable);
    }

    int pageSize=5;







    @Override
    public Catalog_WasteClassificationDto findById(Long catalog_wasteClassificationId) {
        return catalog_wasteClassificationConverter.entityToDto(catalog_wasteClassificationRepository.findById(catalog_wasteClassificationId).orElse(null));
    }

    @Override
    public void addNew(Catalog_WasteClassificationDto catalog_wasteClassificationDto) {
        catalog_wasteClassificationRepository.save(catalog_wasteClassificationConverter.dtoToEntity(catalog_wasteClassificationDto));
    }

    @Override
    public void deleteById(Long catalog_wasteClassificationId) {
        catalog_wasteClassificationRepository.deleteById(catalog_wasteClassificationId);
    }

}
