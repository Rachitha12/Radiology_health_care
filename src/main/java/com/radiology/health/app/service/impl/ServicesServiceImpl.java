package com.radiology.health.app.service.impl;

import com.radiology.health.app.domain.Services;
import com.radiology.health.app.repository.ServicesRepository;
import com.radiology.health.app.service.ServicesService;
import com.radiology.health.app.service.dto.ServicesDTO;
import com.radiology.health.app.service.mapper.ServicesMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.radiology.health.app.domain.Services}.
 */
@Service
@Transactional
public class ServicesServiceImpl implements ServicesService {

    private final Logger log = LoggerFactory.getLogger(ServicesServiceImpl.class);

    private final ServicesRepository servicesRepository;

    private final ServicesMapper servicesMapper;

    public ServicesServiceImpl(ServicesRepository servicesRepository, ServicesMapper servicesMapper) {
        this.servicesRepository = servicesRepository;
        this.servicesMapper = servicesMapper;
    }

    @Override
    public ServicesDTO save(ServicesDTO servicesDTO) {
        log.debug("Request to save Services : {}", servicesDTO);
        Services services = servicesMapper.toEntity(servicesDTO);
        services = servicesRepository.save(services);
        return servicesMapper.toDto(services);
    }

    @Override
    public ServicesDTO update(ServicesDTO servicesDTO) {
        log.debug("Request to update Services : {}", servicesDTO);
        Services services = servicesMapper.toEntity(servicesDTO);
        services = servicesRepository.save(services);
        return servicesMapper.toDto(services);
    }

    @Override
    public Optional<ServicesDTO> partialUpdate(ServicesDTO servicesDTO) {
        log.debug("Request to partially update Services : {}", servicesDTO);

        return servicesRepository
            .findById(servicesDTO.getId())
            .map(existingServices -> {
                servicesMapper.partialUpdate(existingServices, servicesDTO);

                return existingServices;
            })
            .map(servicesRepository::save)
            .map(servicesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ServicesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Services");
        return servicesRepository.findAll(pageable).map(servicesMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ServicesDTO> findOne(Long id) {
        log.debug("Request to get Services : {}", id);
        return servicesRepository.findById(id).map(servicesMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Services : {}", id);
        servicesRepository.deleteById(id);
    }
}
