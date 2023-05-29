package by.mkrs.testApp.service;


import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Catalog_DegreeOfDangerService {

    List<Catalog_DegreeOfDangerDto> listAll();

    Catalog_DegreeOfDangerDto findById(Long degreeOfDangerId);

    void addNew(Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto);

    void deleteById(Long degreeOfDangerId);

    Page<Catalog_DegreeOfDanger> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);

}
