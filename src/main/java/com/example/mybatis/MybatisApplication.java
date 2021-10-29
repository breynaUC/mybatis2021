package com.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.mybatis.repository.CategoriaMyBatisRepository;

@SpringBootApplication
public class MybatisApplication{
@Autowired
private CategoriaMyBatisRepository productoMyBatisRepository;
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	} 

}
