package by.mkrs.testApp.repository;


import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Catalog_DegreeOfDangerRepository
        extends JpaRepository<Catalog_DegreeOfDanger, Long> {


}
