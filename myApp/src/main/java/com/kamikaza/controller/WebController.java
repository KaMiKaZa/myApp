package com.kamikaza.controller;

import com.kamikaza.model.City;
import com.kamikaza.repo.CityRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WebController
{
    //region City Block
    @Autowired
    CityRepo cityRepo;

    @RequestMapping("/myApp/cities")
    public String cityFindAll()
    {
        String result = "";

        for (City c : cityRepo.findAll())
        {
            result += c.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/myApp/cities/ID/{id}")
    @PreAuthorize("hasRole('WORKER') or hasRole('ADMIN')")
    public String cityFindByID(@PathVariable(name = "id") long id)
    {
        String result = "";

        City edited = cityRepo.findById(id).orElse(null);

        if (edited == null)
        {
            result = String.format("Cannot find the City with id=%d", id);
        }
        else
        {
            result = edited.toString();
        }

        return result;
    }

    @RequestMapping("/myApp/cities/ID/{id}/newName={newName}")
    @PreAuthorize("hasRole('WORKER') or hasRole('ADMIN')")
    public String cityChangeName(@PathVariable(name = "id") long id, @PathVariable(name = "newName") String newName)
    {
        String result = "";

        City edited = cityRepo.findById(id).orElse(null);

        if (edited == null)
        {
            result = String.format("Cannot find the City with id=%d", id);
        }
        else
        {
            result = edited.toString() + "  -->  ";

            edited.setName(newName);

            cityRepo.save(edited);

            result += "<b>" + edited.toString() + "</b>";
        }

        return result;
    }


    @RequestMapping("/myApp/cities/ID/{id}/newPopulation={newValue}")
    @PreAuthorize("hasRole('WORKER') or hasRole('ADMIN')")
    public String cityChangePopulation
            (@PathVariable(name = "id") long id, @PathVariable(name = "newValue") int newValue)
    {
        String result = "";

        City edited = cityRepo.findById(id).orElse(null);

        if (edited == null)
        {
            result = String.format("Cannot find the City with id=%d", id);
        }
        else
        {
            result = edited.toString() + "  -->  ";

            edited.setPopulation(newValue);

            cityRepo.save(edited);

            result += "<b>" + edited.toString() + "</b>";
        }

        return result;
    }
    //endregion


    @RequestMapping("/myApp/adminAccess")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess()
    {
        return "This page is for admin only!";
    }


    @RequestMapping("/save")
    public String sss()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String hashPassword = encoder.encode("password");

        return "Done";
    }
}
