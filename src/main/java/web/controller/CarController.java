package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CarController {
    List<Car> carList = new ArrayList<>();
    {

        carList.add(new Car("Mercedes", 2020, 200));
        carList.add(new Car("BMW", 2021, 210));
        carList.add(new Car("Audi", 2022, 220));
        carList.add(new Car("Lada", 2023, 230));
        carList.add(new Car("UAZ", 2024,300));

    }

    @Autowired
    private CarService carService;


    @GetMapping(value = "/cars")
    public String page (Model model, @RequestParam(value = "count", required = false) Integer count) {

        if (count == null) {
            count = 0;
        }
        model.addAttribute("allCars", carService.getCars(carList,count));
        return "cars";

    }



}
