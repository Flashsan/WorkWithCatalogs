package by.mkrs.testApp.repository;


import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Catalog_ClassOfDangerRepository
        extends JpaRepository<Catalog_ClassOfDanger, Long> {


}
