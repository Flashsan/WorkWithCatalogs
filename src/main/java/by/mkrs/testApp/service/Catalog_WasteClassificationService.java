package by.mkrs.testApp.service;


import by.mkrs.testApp.dto.Catalog_WasteClassificationDto;
import by.mkrs.testApp.entity.Catalog_WasteClassification;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Catalog_WasteClassificationService {

    List<Catalog_WasteClassificationDto> listAll(
            int pageNumber,
            int pageSize,
            String sortField,
            String sortDirection);
    Page<Catalog_WasteClassification> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);

    Catalog_WasteClassificationDto findById(Long wasteClassificationId);

    void addNew(Catalog_WasteClassificationDto catalog_WasteClassificationDto);

    void deleteById(Long wasteClassificationId);
}
