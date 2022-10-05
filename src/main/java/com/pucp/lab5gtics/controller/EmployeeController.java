package com.pucp.lab5gtics.controller;

import com.pucp.lab5gtics.entity.Employee;
import com.pucp.lab5gtics.repository.DepartmentRepository;
import com.pucp.lab5gtics.repository.EmployeeRepository;
import com.pucp.lab5gtics.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleado")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    JobRepository jobRepository;

    @GetMapping({"/lista", ""})
    public String listEmployee(Model model, @RequestParam(name = "search",required = false) String search, @RequestParam(name = "order", required = false) Integer order, RedirectAttributes attributes){
        model.addAttribute("listaEmpleados", employeeRepository.findAll(Sort.by("firstName")));
        return "employee/list";
    }
    @GetMapping("/delete")
    public String borrarEmpleado(@RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            employeeRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg","usuario borrado exitosamente");
        return "redirect:/employee";
    }

    //Buscar Empleado
    @PostMapping("/buscar")
    public String searchEmployee(Model model, @RequestParam(name = "search",required = false) String search, @RequestParam(name = "order", required = false) Integer order, RedirectAttributes attributes){
        List<Employee> listafiltrada= employeeRepository.filtrarEmpleados(search);
        model.addAttribute("listaEmpleados", listafiltrada);
        return "employee/list";
    }


    //Editar Empleado
    @GetMapping("/edit")
    public String editarEmpleado(Model model, @RequestParam("id") int id) {
        Optional<Employee> optional = employeeRepository.findById(id);


        if (optional.isPresent()) {
            model.addAttribute("employee", optional.get());
            model.addAttribute("listaDepartamentos", departmentRepository.findAll());
            model.addAttribute("listaTrabajos", jobRepository.findAll());
            return "employee/editFrm";
        } else {
            return "redirect:/empleado";
        }

    }
    @PostMapping("/save")
    public String guardarEmpleado(Employee employee){
        employeeRepository.save(employee);
        return "redirect:/empleado";
    }
    //Guardar Empleado
    @PostMapping("save")
    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/empleado";
    }

    @GetMapping("nuevo")
    public String newEmployee(Model model) {
        model.addAttribute("listaDepartamentos", departmentRepository.findAll());
        model.addAttribute("listaTrabajos", jobRepository.findAll());
        return "employee/crearFrm";
    }
}
