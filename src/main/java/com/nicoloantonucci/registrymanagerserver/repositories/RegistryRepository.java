package com.nicoloantonucci.registrymanagerserver.repositories;

import com.nicoloantonucci.registrymanagerserver.model.Registry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

    @Query(
            value = "SELECT * FROM registries r " +
                    "WHERE LOWER(r.name) LIKE LOWER('%?1%') " +
                    "AND LOWER(r.surname) LIKE LOWER('%?2%')"/* +
                    "AND LOWER(address) LIKE LOWER('%?3%')" +
                    "AND LOWER(location) LIKE LOWER('%?4%')" +
                    "AND LOWER(city) LIKE LOWER('%?5%')" +
                    "AND LOWER(province) LIKE LOWER('%?6%')" +
                    "AND LOWER(email) LIKE LOWER('%?7%')" +
                    "AND LOWER(notes) LIKE LOWER('%?8%')"*/,
            countQuery = "SELECT count(*) FROM registries r " +
                    "WHERE LOWER(r.name) LIKE LOWER('%?1%') " +
                    "AND LOWER(r.surname) LIKE LOWER('%?2%')"/* +
                    "AND LOWER(address) LIKE LOWER('%?3%')" +
                    "AND LOWER(location) LIKE LOWER('%?4%')" +
                    "AND LOWER(city) LIKE LOWER('%?5%')" +
                    "AND LOWER(province) LIKE LOWER('%?6%')" +
                    "AND LOWER(email) LIKE LOWER('%?7%')" +
                    "AND LOWER(notes) LIKE LOWER('%?8%')"*/,
            nativeQuery = true
    )
    Page<Registry> findAllByQuery(String name,
                                  String surname,
                                  @Param("address") String address,
                                  @Param("location") String location,
                                  @Param("city") String city,
                                  @Param("province") String province,
                                  @Param("email") String email,
                                  @Param("notes") String notes,
                                  Pageable pageable
    );
}
