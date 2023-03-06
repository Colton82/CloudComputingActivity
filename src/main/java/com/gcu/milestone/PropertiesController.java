package com.gcu.milestone;

import model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PropertiesController 
{
    List<PropertyModel> properties = new ArrayList<PropertyModel>();

    public PropertiesController()
    {
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
        properties.add(new PropertyModel());
    }

    @GetMapping("/properties")
    public String display(Model model)
    {
        model.addAttribute("properties", properties);
        return "properties/properties1";
    }

}