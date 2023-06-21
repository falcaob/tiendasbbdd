package com.corecursos.tiendasbd.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corecursos.tiendasbd.model.entity.Tienda;
import com.corecursos.tiendasbd.services.ITiendasService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tiendas")
public class TiendasController {

	@Autowired
	private ITiendasService tiendaService;

	@GetMapping("/listar")
	public String listadoClientes(Map<String, Object> model) {

		model.put("titulo", "Listado de Tiendas");
		// acceso a la bbdd
		model.put("tiendas", tiendaService.findAll());

		return "tiendas/listar";
	}

	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		// enchufo un cliente, que de momento no tiene datos específicos
		model.put("titulo", "Formulario de cliente");
		model.put("tienda", new Tienda());
		return "tiendas/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Tienda tienda, BindingResult result, Model model) { // la anotación para que se
		// habiliten las validaciones
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Tienda");
			return "tiendas/form";
		}
		tiendaService.save(tienda);
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String actualizar(@PathVariable("id") Long id, Map<String, Object> model) {
		Tienda tienda = null;
		if (id > 0) {
			tienda = tiendaService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("tienda", tienda);
		model.put("titulo", "Editar tienda");
		return "tiendas/form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		if (id > 0)
			tiendaService.delete(id);
		return "redirect:/tiendas/listar";
	}

}
