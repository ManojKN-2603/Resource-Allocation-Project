package com.estuate.ResourceAllocation.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estuate.ResourceAllocation.dto.ResourceDto;
import com.estuate.ResourceAllocation.service.ResourceService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class ResourceController {

	@Autowired
	ResourceService service;

	@GetMapping("/")
	public String home() {
		return service.home();
	}

	@GetMapping("addDetails")
	public String addDetails() {
		return service.addDetails();
	}

	@PostMapping("/addDetails")
	public String postDetails(ResourceDto resourceDto, HttpSession session) {
		return service.postDetails(resourceDto, session);
	}

	@GetMapping("/searchAll")
	public String fetchAll(HttpSession session) {
		return service.fetchAll(session);
	}

	@GetMapping("/edit/{resourceId}")
	public String editProducts(@PathVariable("resourceId") int resourceId, HttpSession session) {
		return service.editProduct(resourceId, session);
	}

	@PostMapping("/editResource")
	public String editProducts(ResourceDto resourceDto,HttpSession session) {
		return service.editProducts(resourceDto,session);
	}

	@GetMapping("/delete/{resourceId}")
	public String delete(@PathVariable("resourceId") int resourceId, HttpSession session) {
		return service.delete(resourceId, session);
	}

	@GetMapping("/search")
	public String search() {
		return service.search();
	}

	@GetMapping("/searchBS")
	public String search(@RequestParam("skills") ArrayList<String> skills, HttpSession session) {
		return service.searchBS(skills, session);
	}

	@GetMapping("/searchBSAE")
	public String search(@RequestParam("skills") String skills, @RequestParam("experience") int experience,
			HttpSession session) {
		return service.search(skills, experience, session);
	}
}