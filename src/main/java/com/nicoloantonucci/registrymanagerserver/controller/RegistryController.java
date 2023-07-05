package com.nicoloantonucci.registrymanagerserver.controller;

import com.nicoloantonucci.registrymanagerserver.model.*;
import com.nicoloantonucci.registrymanagerserver.repositories.RegistryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            @RequestBody ReadRegistriesBody readRegistriesBody
    ) {
        if (readRegistriesBody.getPage() < 1) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Invalid page number"));
        }

        if (readRegistriesBody.getElementsPerPage() < 1) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Invalid number of elements per page"));
        }

        ArrayList<Registry> registries = new ArrayList<>(repository.findAll());
        int pages = (int) Math.ceil((double) registries.size() / (double) readRegistriesBody.getElementsPerPage());
        int page = readRegistriesBody.getPage() > pages ? pages : readRegistriesBody.getPage();
        Set<Registry> result = IntStream.range(0, registries.size())
                .filter(i -> i >= (page - 1) * readRegistriesBody.getElementsPerPage() && i < (page * readRegistriesBody.getElementsPerPage()))
                .mapToObj(registries::get)
                .collect(Collectors.toSet());

        return new ResponseSchema<>(true, new ReadRegistriesDto(result,
                page,
                pages,
                readRegistriesBody.getElementsPerPage(),
                registries.size()
        ), null);
    }

    @PostMapping("/new")
    public ResponseSchema<ReadRegistriesDto, BaseError> postRegistry(@Valid @NotNull @RequestBody PostRegistryBody postRegistryBody) {
        try {
            Registry result = repository.save(new Registry(postRegistryBody));
            ArrayList<Registry> registries = new ArrayList<>(repository.findAll());
            int pages = (int) Math.ceil((double) registries.size() / (double) postRegistryBody.getElementsPerPage());
            int index = registries.indexOf(result);
            int page = Math.max((int) Math.ceil((double) index / (double) postRegistryBody.getElementsPerPage()), 1);
            Set<Registry> registriesSet = IntStream.range(0, registries.size())
                    .filter(i -> i >= (page - 1) * postRegistryBody.getElementsPerPage() && i < (page * postRegistryBody.getElementsPerPage()))
                    .mapToObj(registries::get)
                    .collect(Collectors.toSet());

            return new ResponseSchema<>(true, new ReadRegistriesDto(registriesSet,
                    page,
                    pages,
                    postRegistryBody.getElementsPerPage(),
                    registries.size()
            ), null);
        } catch (IllegalArgumentException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.BAD_REQUEST, "Registry cannot be null"));
        } catch (OptimisticLockException e) {
            return new ResponseSchema<>(false, null, new BaseError(HttpStatus.CONFLICT, "Conflict"));
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

    @DeleteMapping("/{id}")
    public ResponseSchema<DeleteRegistryResponse, BaseError> deleteRegistry(@PathVariable @NotNull Integer id) {
        try {
            Optional<Registry> result = repository.findById(id);
            if (result.isPresent()) {
                repository.deleteById(id);
                return new ResponseSchema<>(true, new DeleteRegistryResponse(true), null);
            }
            throw new EntityNotFoundException();
        } catch (IllegalArgumentException e) {
            return new ResponseSchema<>(false, new DeleteRegistryResponse(false), new BaseError(HttpStatus.BAD_REQUEST, "Invalid id"));
        } catch (OptimisticLockException e) {
            return new ResponseSchema<>(false, new DeleteRegistryResponse(false), new BaseError(HttpStatus.CONFLICT, "Conflict"));
        } catch (EntityNotFoundException e) {
            return new ResponseSchema<>(false, new DeleteRegistryResponse(false), new BaseError(HttpStatus.NOT_FOUND, "Registry not found"));
        } catch (Exception e) {
            return new ResponseSchema<>(false, new DeleteRegistryResponse(false), new BaseError(HttpStatus.INSUFFICIENT_STORAGE, "Internal server error"));
        }
    }


}
