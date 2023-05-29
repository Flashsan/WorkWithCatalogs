package by.mkrs.testApp.service;


import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Catalog_ClassOfDangerService {

    List<Catalog_ClassOfDangerDto> listAll();

    Catalog_ClassOfDangerDto findById(Long catalog_classOfDangerId);

    void addNew(Catalog_ClassOfDangerDto catalog_classOfDangerDto);

    void deleteById(Long catalog_classOfDangerId);

    Page<Catalog_ClassOfDanger> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);

}
