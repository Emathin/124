package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCarga {

    private final ServicioCarga servicioCarga;

    @Autowired
    public ControladorCarga(ServicioCarga servicioCarga) {
        this.servicioCarga = servicioCarga;
    }

    @PostMapping("/guardarCarga")
    public ModelAndView guardarCarga(CargaDTO cargaDTO) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("respuestaDeCarga");
        if(servicioCarga.guardarCarga(cargaDTO)){
            mav.addObject("mensaje","Carga exitosa");
        }else {
            mav.addObject("mensaje","Carga fallida");
        }
        return mav;
    }

    @GetMapping("/cargarCombustible")
    public ModelAndView cargarCombustible() {
        ModelAndView mav = new ModelAndView("cargarCombustible");
        mav.addObject("cargaDTO", new CargaDTO());
        return mav;
    }
}
