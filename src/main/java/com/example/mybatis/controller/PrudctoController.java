/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.controller;


import com.example.mybatis.entity.Producto;
import com.example.mybatis.repository.CategoriaMyBatisRepository;
import com.example.mybatis.repository.ProductoMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author BReyna
 */
@Controller
public class PrudctoController {

    @Autowired
    private CategoriaMyBatisRepository categoriaMyBatisRepository;

    @Autowired
    private ProductoMyBatisRepository productoMyBatisRepository;

    @RequestMapping("/prods")
    public String prods(Model model) {
        model.addAttribute("prods", productoMyBatisRepository.findAll());
        return "producto/prods";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("cats", categoriaMyBatisRepository.findAll());
        return "producto/addProd";
    }

    @RequestMapping("/prodadd")
    public String guardar(@RequestParam String nombre, @RequestParam double precio, @RequestParam int stock, @RequestParam int idcat, Model model) {
        Producto prod = new Producto();
        prod.setNombre(nombre);
        prod.setPrecio(precio);
        prod.setStock(stock);
        prod.setIdcategoria(idcat);
        productoMyBatisRepository.insert(prod);
        return "redirect:/prods";
    }
    @RequestMapping("/delprod/{id}")
    public String deleteprod(@PathVariable(value="id") int id) {
        productoMyBatisRepository.deleteById(id);
        return "redirect:/prods";
    }
    @RequestMapping("/editprod/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("cats", categoriaMyBatisRepository.findAll());
        model.addAttribute("prod", productoMyBatisRepository.readProducto(id));
        return "producto/editprod";
    }
    @RequestMapping("/updateprod")
    public String update(@RequestParam int idproducto, @RequestParam String nombre, 
            @RequestParam double precio,  @RequestParam int stock, @RequestParam int idcategoria) {
        System.out.println(idproducto+"/"+nombre+"/"+precio+"/"+stock+"/"+idcategoria);
        Producto prod = productoMyBatisRepository.readProducto(idproducto);
        prod.setNombre(nombre);
        prod.setPrecio(precio);
        prod.setStock(stock);
        prod.setIdcategoria(idcategoria);
        productoMyBatisRepository.update(prod);
        return "redirect:/prods";
    }
}
