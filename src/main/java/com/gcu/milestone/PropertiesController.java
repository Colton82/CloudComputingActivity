package com.gcu.milestone;

import model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import data.PropertiesDataServiceInterface;


@Controller
@RequestMapping("/properties")
public class PropertiesController 
{
    @Autowired
    private PropertiesDataServiceInterface service;

    //List<PropertyModel> properties = new ArrayList<PropertyModel>();

    public PropertiesController()
    {
        //properties = dataService.getOrders();
    }

    @GetMapping("/")
    public String showAllOrders(Model model)
    {
        List<PropertyModel> properties = service.getOrders();
		
		model.addAttribute("title", "Show all orders");
		//model.addAttribute("searchOrdersModel", new SearchOrdersModel());
		model.addAttribute("properties", properties); 
		return "properties/properties1";
    }

    @GetMapping("/searchForm")
    public String displaySearchForm(Model model)
    {
        model.addAttribute("title", "Search for Orders");
        model.addAttribute("searchPropertyModel", new SearchPropertyModel());
        return "properties/propertiesSearchForm";
    }

    @PostMapping("/searchResults")
    public String showProperties(SearchPropertyModel searchModel, Model model)
    {
        List<PropertyModel> properties = service.searchOrders(searchModel.getSearchTerm());
        model.addAttribute("title", "Search for Orders");
		model.addAttribute("searchPropertyModel", searchModel);
		model.addAttribute("properties", properties);
        return "properties/properties1";
    }

    @GetMapping("/addNewForm")
    public String displayAddNewForm(Model model)
    {
        model.addAttribute("title", "Add new order");
		model.addAttribute("propertyModel", new PropertyModel());
		return "properties/addNewForm";

    }

    @PostMapping("/addNew") 
	// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
	public String addProperty(PropertyModel property, Model model) {
		// add the new order
		service.addOne(property);
		// get updated list of all the orders
		List<PropertyModel> properties = service.getOrders(); 
		
		// display all orders
		model.addAttribute("properties", properties); 
		model.addAttribute("title", "Added an item");
		model.addAttribute("searchPropertyModel", new SearchPropertyModel()); 
		return "properties/properties1";
	}




}