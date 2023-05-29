package by.mkrs.testApp.repository;

import by.mkrs.testApp.entity.Catalog_WasteClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Catalog_WasteClassificationRepository
        extends JpaRepository<Catalog_WasteClassification, Long> {


}
