package com.hello.myideademo.dao;

import org.springframework.data.repository.CrudRepository;

import com.hello.myideademo.model.Data;

public interface Datadao extends CrudRepository<Data,Integer>
{

}