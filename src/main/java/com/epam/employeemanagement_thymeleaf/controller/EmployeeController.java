package com.epam.employeemanagement_thymeleaf.controller;

import com.epam.employeemanagement_thymeleaf.model.Employee;
import com.epam.employeemanagement_thymeleaf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/createEmployee")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee ){
        employeeService.saveEmployee(employee);
        return "redirect:/employees/";
    }
    @GetMapping("/updateEmployee/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
      this.employeeService.deleteEmployeeById(id);
      return "redirect:/employees/";
    }
}
