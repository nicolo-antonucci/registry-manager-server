package com.nicoloantonucci.registrymanagerserver.controller;

import com.nicoloantonucci.registrymanagerserver.model.*;
import com.nicoloantonucci.registrymanagerserver.repositories.RegistryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/registries")
public class RegistryController {
    @Autowired
    private final RegistryRepository repository;

    public RegistryController(RegistryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("")
    public ResponseSchema<ReadRegistriesDto, BaseError> readRegistries(
            @RequestBody ReadRegistriesBody readRegistriesBody,
            @PageableDefault(size = 5)
            @SortDefault.SortDefaults(@SortDefault(sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC))
            Pageable pageable
    ) {
        Page<Registry> registries = repository.findAllByQuery(
                readRegistriesBody.getName() != null ? readRegistriesBody.getName() : "",
                readRegistriesBody.getSurname() != null ? readRegistriesBody.getSurname() : "",
                readRegistriesBody.getAddress() != null ? readRegistriesBody.getAddress() : "",
                readRegistriesBody.getLocation() != null ? readRegistriesBody.getLocation() : "",
                readRegistriesBody.getCity() != null ? readRegistriesBody.getCity() : "",
                readRegistriesBody.getProvince() != null ? readRegistriesBody.getProvince() : "",
                readRegistriesBody.getEmail() != null ? readRegistriesBody.getEmail() : "",
                readRegistriesBody.getNotes() != null ? readRegistriesBody.getNotes() : "",
                pageable
        );


        return new ResponseSchema<>(true, new ReadRegistriesDto(registries.toSet(),
                pageable.getPageNumber(),
                registries.getTotalPages(),
                pageable.getPageSize(),
                (int) registries.getTotalElements(),
                null), null);
    }

    @PostMapping("/new")
    public ResponseSchema<ReadRegistriesDto, BaseError> postRegistry(@Valid @NotNull @RequestBody PostRegistryBody postRegistryBody,
                                                                     @PageableDefault(size = 20)
                                                                     @SortDefault.SortDefaults(@SortDefault(sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC))
                                                                     Pageable pageable) {
        try {
            Registry result = repository.save(new Registry(postRegistryBody));
            ArrayList<Registry> allRegistries = new ArrayList<>(repository.findAll());
            Pageable newPageable = pageable.withPage((int) Math.floor((double) allRegistries.indexOf(result) / (double) pageable.getPageSize()));
            Page<Registry> registries = repository.findAll(pageable);
            return new ResponseSchema<>(true, new ReadRegistriesDto(registries.toSet(),
                    Math.min(registries.getTotalPages(), newPageable.getPageNumber()),
                    registries.getTotalPages(),
                    pageable.getPageSize(),
                    (int) registries.getTotalElements(),
                    null), null);
        } catch (IllegalArgumentException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Registry cannot be null"));
        } catch (OptimisticLockException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.CONFLICT, "Conflict"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseSchema<DeleteRegistriesDto, BaseError> deleteRegistry(@PathVariable @NotNull Integer id, @RequestBody @NotNull ReadRegistriesBody deleteRegistryBody,
                                                                         @PageableDefault(size = 20)
                                                                         @SortDefault.SortDefaults(@SortDefault(sort = "name", direction = org.springframework.data.domain.Sort.Direction.ASC))
                                                                         Pageable pageable) {
        try {
            Optional<Registry> entity = repository.findById(id);
            if (entity.isPresent()) {
                repository.deleteById(id);
                return new ResponseSchema<>(true, new DeleteRegistriesDto(false), null);
            }
            throw new EntityNotFoundException();
        } catch (IllegalArgumentException e) {
            return new ResponseSchema<>(false, new DeleteRegistriesDto(false), new BaseError(HttpStatus.BAD_REQUEST, "Invalid id"));
        } catch (OptimisticLockException e) {
            return new ResponseSchema<>(false, new DeleteRegistriesDto(false), new BaseError(HttpStatus.CONFLICT, "Conflict"));
        } catch (EntityNotFoundException e) {
            return new ResponseSchema<>(false, new DeleteRegistriesDto(false), new BaseError(HttpStatus.NOT_FOUND, "Registry not found"));
        } catch (Exception e) {
            return new ResponseSchema<>(false, new DeleteRegistriesDto(false), new BaseError(HttpStatus.INSUFFICIENT_STORAGE, "Internal server error"));
        }
    }

    @GetMapping("/{id}")
    public ResponseSchema<Registry, BaseError> getRegistry(@PathVariable Integer id) {
        try {
            Optional<Registry> result = repository.findById(id);
            if (result.isPresent()) {
                return new ResponseSchema<>(true,
                        result.get(),
                        null
                );
            }
            throw new EntityNotFoundException();
        } catch (NumberFormatException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Invalid id"));
        } catch (EntityNotFoundException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.NOT_FOUND, "Registry not found"));
        }
    }

    @PutMapping("/{id}")
    public ResponseSchema<UpdateRegistryResponse, BaseError> updateRegistry(@PathVariable @NotNull Integer id, @Valid @NotNull @RequestBody PostRegistryBody registry) {
        try {
            Optional<Registry> result = repository.findById(id);
            if (result.isPresent()) {
                repository.save(new Registry(id, registry));
                return new ResponseSchema<>(true, new UpdateRegistryResponse(true), null);
            }
            throw new EntityNotFoundException();
        } catch (IllegalArgumentException e) {
            return new ResponseSchema<>(false, new UpdateRegistryResponse(false), new BaseError(HttpStatus.BAD_REQUEST, "Registry cannot be null"));
        } catch (EntityNotFoundException e) {
            return new ResponseSchema<>(false, new UpdateRegistryResponse(false), new BaseError(HttpStatus.NOT_FOUND, "Registry not found"));
        } catch (Exception e) {
            return new ResponseSchema<>(false, new UpdateRegistryResponse(false), new BaseError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"));
        }

    }
}
