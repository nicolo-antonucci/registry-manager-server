package com.nicoloantonucci.registrymanagerserver.repositories;

import com.nicoloantonucci.registrymanagerserver.model.Registry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

    @Query(
            value = "SELECT * FROM registries r " +
                    "WHERE (LENGTH(:name) = 0 OR r.name LIKE %:name%) " +
                    "AND (LENGTH(:surname) = 0 OR r.surname LIKE %:surname%) " +
                    "AND (LENGTH(:address) = 0 OR address LIKE %:address%) " +
                    "AND (LENGTH(:location) = 0 OR location LIKE %:location%) " +
                    "AND (LENGTH(:city) = 0 OR city LIKE %:city%) " +
                    "AND (LENGTH(:province) = 0 OR province LIKE %:province%) " +
                    "AND (LENGTH(:email) = 0 OR email LIKE %:email%) " +
                    "AND (LENGTH(:notes) = 0 OR notes LIKE %:notes%)",
            countQuery = "SELECT count(*) FROM registries r " +
                    "WHERE (LENGTH(:name) = 0 OR r.name LIKE %:name%) " +
                    "AND (LENGTH(:surname) = 0 OR r.surname LIKE %:surname%) " +
                    "AND (LENGTH(:address) = 0 OR address LIKE %:address%) " +
                    "AND (LENGTH(:location) = 0 OR location LIKE %:location%) " +
                    "AND (LENGTH(:city) = 0 OR city LIKE %:city%) " +
                    "AND (LENGTH(:province) = 0 OR province LIKE %:province%) " +
                    "AND (LENGTH(:email) = 0 OR email LIKE %:email%) " +
                    "AND (LENGTH(:notes) = 0 OR notes LIKE %:notes%)",
            nativeQuery = true
    )
    Page<Registry> findAllByQuery(@Param("name") String name,
                                  @Param("surname") String surname,
                                  @Param("address") String address,
                                  @Param("location") String location,
                                  @Param("city") String city,
                                  @Param("province") String province,
                                  @Param("email") String email,
                                  @Param("notes") String notes,
                                  Pageable pageable
    );
}
