/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mybatis.repository;


import com.example.mybatis.entity.Producto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author BReyna
 */
@Mapper
public interface ProductoMyBatisRepository {
    
    @Select("select p.idproducto, p.nombre, p.precio, p.stock, c.idcategoria, c.nombre as categoria from producto as p " +
    "inner join categoria as c on p.idcategoria = c.idcategoria")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from producto where idproducto=#{id}")
    public Producto readProducto(int id);

    @Delete("DELETE FROM producto WHERE idproducto = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO producto(nombre, precio, stock, idcategoria) VALUES (#{nombre}, #{precio}, #{stock}, #{idcategoria})")
    public int insert(Producto producto);
    //UPDATE `bdejemplo`.`producto` SET `nombre` = 'www', `precio` = '5', `idcategoria` = '2' WHERE (`idproducto` = '19');
    @Update("Update producto set nombre=#{nombre}, precio=#{precio}, stock=#{stock}, idcategoria=#{idcategoria} where idproducto=#{idproducto}")
    public int update(Producto producto);
}
