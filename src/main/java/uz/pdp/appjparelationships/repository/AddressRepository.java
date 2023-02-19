package uz.pdp.appjparelationships.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
