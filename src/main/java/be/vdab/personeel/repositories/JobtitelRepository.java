package be.vdab.personeel.repositories;

import be.vdab.personeel.domain.Jobtitel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long> {
    List<Jobtitel> findAll();
    Optional<Jobtitel> findById(long id);
}
