package com.estuate.ResourceAllocation.service;

import java.util.ArrayList;

import com.estuate.ResourceAllocation.dto.ResourceDto;

import jakarta.servlet.http.HttpSession;

public interface ResourceService {
	String home();

	String addDetails();

	String postDetails(ResourceDto resourceDto, HttpSession session);

	String fetchAll(HttpSession session);

	String delete(int id, HttpSession session);

	String editProduct(int id, HttpSession session);

	String editProducts(ResourceDto resourceDto, HttpSession session);

	String search();

	String searchBS(ArrayList<String> skills, HttpSession session);

	String search(ArrayList<String> skills, int experience, HttpSession session);

}
