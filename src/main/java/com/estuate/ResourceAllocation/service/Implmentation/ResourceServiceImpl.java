package com.estuate.ResourceAllocation.service.Implmentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estuate.ResourceAllocation.dto.ResourceDto;
import com.estuate.ResourceAllocation.repository.ResourceRepository;
import com.estuate.ResourceAllocation.service.ResourceService;

import jakarta.servlet.http.HttpSession;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	ResourceRepository repository;

	@Autowired
	ResourceDto resourceDto;

	@Override
	public String home() {
		return "home.html";
	}

	@Override
	public String addDetails() {
		return "addDetails.html";
	}

	@Override
	public String postDetails(ResourceDto resourceDto, HttpSession session) {
		repository.save(resourceDto);
		session.setAttribute("success", "Resource Added Successfully");
		return "redirect:/";
	}

	@Override
	public String fetchAll(HttpSession session) {
		List<ResourceDto> resources = repository.findAll();
		if (resources.isEmpty()) {
			session.setAttribute("failure", "Resource Not Found");
			return "redirect:/";
		} else {
			session.setAttribute("resources", resources);
			return "viewAll.html";
		}
	}

	@Override
	public String editProduct(int id, HttpSession session) {
		ResourceDto resource = repository.findById(id).orElseThrow();
		session.setAttribute("resource", resource);
		return "edit.html";
	}

	@Override
	public String editProducts(ResourceDto resourceDto, HttpSession session) {
		repository.save(resourceDto);
		session.setAttribute("success", "Resource Updated Successfully");
		return "redirect:/searchAll";
	}

	@Override
	public String delete(int resourceId, HttpSession session) {
		repository.deleteById(resourceId);
		session.setAttribute("success", "Resources deleted Successfully");
		return "redirect:/searchAll";
	}

	@Override
	public String search() {
		return "search.html";
	}

	@Override
	public String searchBS(ArrayList<String> skills, HttpSession session) {
		List<String> resources = repository.findAll().stream()
				.filter(resource -> resource.getSkills().stream().map(String::toLowerCase).collect(Collectors.toList())
						.containsAll(skills.stream().map(String::toLowerCase).collect(Collectors.toList())))
				.map(resource -> resource.getResourceName()).collect(Collectors.toList());
		if (resources.isEmpty())
		{
			session.setAttribute("failure", "Resource Not Found");
			return "redirect:/";
		} else {
			session.setAttribute("resources", resources);
			return "result.html";
		}

	}

	@Override
	public String search(String skills, int experience, HttpSession session) {
		List<String> resources = repository.findAll().stream()
				.filter(resource -> resource.getExperience() <= experience)
				.filter(resource -> resource.getSkills().contains(skills)).map(resource -> resource.getResourceName())
				.collect(Collectors.toList());
		if (resources.isEmpty()) {
			session.setAttribute("failure", "Resource Not Found");
			return "redirect:/";
		} else {
			session.setAttribute("resources", resources);
			return "result.html";
		}
	}

}
