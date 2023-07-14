package com.proin.albaran.controller;

import org.jeasy.random.EasyRandom;

import com.proin.albaran.util.EasyRandomUtils;

public interface BaseController<Entity,Dto> {

	final EasyRandom EASY_RANDOM = EasyRandomUtils.generateEasyRandom();

	Dto convertToDto(Entity dto);
	
	Entity convertToEntity(Dto entity);

	abstract void configMappingDto();
}