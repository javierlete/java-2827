package com.ipartek.formacion.springapp.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.springapp.entidades.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>, PagingAndSortingRepository<Categoria, Long> {

}
