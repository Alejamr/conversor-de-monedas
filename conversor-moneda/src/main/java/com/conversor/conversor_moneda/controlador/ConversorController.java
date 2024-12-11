package com.conversor.conversor_moneda.controlador;


import com.conversor.conversor_moneda.servicio.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {

    @Autowired
    private ConversorService conversorService;

    @GetMapping("/convertir")
    public String convertir(@RequestParam String desde, @RequestParam String hacia, @RequestParam double monto) {
        return conversorService.convertir(desde, hacia, monto);
    }

}



