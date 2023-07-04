package com.nicoloantonucci.registrymanagerserver.repositories;

import com.nicoloantonucci.registrymanagerserver.model.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {
}
