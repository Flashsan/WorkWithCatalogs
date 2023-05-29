package by.mkrs.testApp.repository;


import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Catalog_KindOfActivityRepository
        extends JpaRepository<Catalog_KindOfActivity, Long>{


}
