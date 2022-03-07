package com.example.springdata.product.files.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.product.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
