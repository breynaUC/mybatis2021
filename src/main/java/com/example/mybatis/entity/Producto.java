/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author BReyna
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto implements Serializable{
    private static final long serialVersionUID = 3754851399214200439L;
	private int idproducto;
	private String nombre;
	private double precio;
	private int stock;	
	private int idcategoria;
}
