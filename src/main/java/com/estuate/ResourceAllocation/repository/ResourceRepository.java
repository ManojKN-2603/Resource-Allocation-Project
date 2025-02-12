package com.estuate.ResourceAllocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estuate.ResourceAllocation.dto.ResourceDto;

public interface ResourceRepository extends JpaRepository<ResourceDto, Integer> {

}
