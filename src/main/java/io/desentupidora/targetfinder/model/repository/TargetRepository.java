package io.desentupidora.targetfinder.model.repository;

import io.desentupidora.targetfinder.model.domain.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TargetRepository extends JpaRepository<Target, UUID> {

    Optional<Target> findByTitle(String title);
}
