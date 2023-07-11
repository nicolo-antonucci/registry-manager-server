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
                    "WHERE (:name IS NULL OR LENGTH(:name) = 0 OR r.name LIKE %:name%) " +
                    "AND (:surname IS NULL OR LENGTH(:surname) = 0 OR r.surname LIKE %:surname%) " +
                    "AND (:address IS NULL OR LENGTH(:address) = 0 OR address LIKE %:address%) " +
                    "AND (:location IS NULL OR LENGTH(:location) = 0 OR location LIKE %:location%) " +
                    "AND (:city IS NULL OR LENGTH(:city) = 0 OR city LIKE %:city%) " +
                    "AND (:province IS NULL OR LENGTH(:province) = 0 OR province LIKE %:province%) " +
                    "AND (:email IS NULL OR LENGTH(:email) = 0 OR email LIKE %:email%) " +
                    "AND (:notes IS NULL OR LENGTH(:notes) = 0 OR notes LIKE %:notes%)",
            countQuery = "SELECT count(*) FROM registries r " +
                    "WHERE (:name IS NULL OR LENGTH(:name) = 0 OR r.name LIKE %:name%) " +
                    "AND (:surname IS NULL OR LENGTH(:surname) = 0 OR r.surname LIKE %:surname%) " +
                    "AND (:address IS NULL OR LENGTH(:address) = 0 OR address LIKE %:address%) " +
                    "AND (:location IS NULL OR LENGTH(:location) = 0 OR location LIKE %:location%) " +
                    "AND (:city IS NULL OR LENGTH(:city) = 0 OR city LIKE %:city%) " +
                    "AND (:province IS NULL OR LENGTH(:province) = 0 OR province LIKE %:province%) " +
                    "AND (:email IS NULL OR LENGTH(:email) = 0 OR email LIKE %:email%) " +
                    "AND (:notes IS NULL OR LENGTH(:notes) = 0 OR notes LIKE %:notes%)",
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
