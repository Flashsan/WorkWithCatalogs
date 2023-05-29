package by.mkrs.testApp.service;


import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Catalog_KindOfActivityService {


    List<Catalog_KindOfActivityDto> listAll();

    Catalog_KindOfActivityDto findById(Long kindOfActivityDtoId);

    void addNew(Catalog_KindOfActivityDto catalog_kindOfActivityDto);

    void deleteById(Long kindOfActivityDtoId);

    Page<Catalog_KindOfActivity> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);
}
