package com.estuate.ResourceAllocation.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private ArrayList<String> skills;
	private int experience;
}
