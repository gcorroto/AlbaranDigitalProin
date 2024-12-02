package com.proin.albaran.configuration.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.entity.AlbaranEntity;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);

		modelMapper.createTypeMap(AlbaranEntity.class,AlbaranDto.class)
			.addMappings(mapper -> mapper.map(src -> src.getId().getNumeroalbaran(), AlbaranDto::setNumeroAlbaran))
			.addMappings(mapper -> mapper.map(src -> src.getId().getCentro(), AlbaranDto::setCentro))
			.addMappings(mapper -> mapper.map(src -> src.getId().getCodigoPlanta(), AlbaranDto::setCodigoPlanta))
			.addMappings(mapper -> mapper.map(src -> src.getId().getSerie(), AlbaranDto::setSerie))
			.addMappings(mapper -> mapper.map(src -> src.getDescripcionHormigonEntity().getEspecificacion(), AlbaranDto::setEspecificacion))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getClima(), AlbaranDto::setClima))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getDireccionViento(), AlbaranDto::setDireccionViento))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getHumedad(), AlbaranDto::setHumedad))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getIntensidadPrecipitacion(), AlbaranDto::setIntensidadPrecipitacion))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getPresion(), AlbaranDto::setPresion))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getPrevision(), AlbaranDto::setPrevision))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getRazonesClima(), AlbaranDto::setRazonesClima))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getTemperatura(), AlbaranDto::setTemperatura))
			.addMappings(mapper -> mapper.map(src -> src.getEvaluacionMeteorologicaEntity().getVelocidadViento(), AlbaranDto::setVelocidadViento));
			
		return modelMapper;
	}
	
}
