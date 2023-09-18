package com.proin.albaran.constantes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.proin.albaran.dto.AlbaranDto;
import com.proin.albaran.dto.BaseDto;
import com.proin.albaran.dto.ClienteDto;
import com.proin.albaran.dto.HormigonDto;
import com.proin.albaran.dto.MeteorologiaDto;
import com.proin.albaran.dto.TransporteDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Getter
@JsonSerialize(using = MetadataAlbaranEnumSerializer.class)
public enum  MetadataAlbaranEnum {

    //CLIENTE
    NUMALBARAN("numAlbaran","Nº Albarán","Cliente",0, "Number"),
    FECHAENTREGA("fechaEntrega","Fecha de entrega","Cliente",1,"Label"),
    RADIAL("radial","Radial","Cliente",2,"Label"),
    M3("m3","M3 entregados","Cliente",3,"Label"),
    PROGRESODIA("progresoDia","Total progres día","Cliente",4,"Label"),
    PLANTA("planta","Planta","Cliente",5,"Label"),
    VIACARGA("viaCarga","viaCarga","Cliente",6,"Label"),
    CLIENTE_NOMBRE("cliente.nombre","Cliente","Cliente",7,"Label"),
    CLIENTE_ID("cliente.id","Nº Cliente","Cliente",8,"Label"),
    CLIENTE_CIF("cliente.cif","CIF","Cliente",9,"Label"),
    OBRA("obra","Obra","Cliente",10,"Label"),
    DIRECCION("direccion","Dirección","Cliente",11,"Label"),
    CP("cp","Población","Cliente",12,"Label"),
    MUNICIPIO("municipio","Municipio","Cliente",13,"Label"),

    //TRANSPORTE
    TRANSPORTE_EMPRESA("transporte.empresa","Empresa","Transporte",14, "Label"),
    TRANSPORTE_CIF("transporte.cif","cif","Transporte",15, "Label"),
    TRANSPORTE_CAMION_MATRICULA("transporte.camion.matricula","Matrícula Camión","Transporte",16, "Label"),
    TRANSPORTE_REMOLQUE_MATRICULA("transporte.remolque.matricula","Matrícula Remolque","Transporte",17, "Label"),
    TRANSPORTE_CARGADOR_CONTRACTUAL("transporte.cargadorContractual","Cargador Contractual","Transporte",18, "Label"),

    //HORMIGON
    HORMIGON_TIPO("hormigon.tipo","Tipo de Hormigón/Mortero","Hormigón",19, "Label"),
    HORMIGON_REFERENCIA("hormigon.referencia","Ficha Técnica de Referencia","Hormigón",20, "Label"),
    HORMIGON_RELACION("hormigon.relacion","Ficha Técnica de Relación","Hormigón",21, "Label"),
    HORMIGON_ADICIONES_TIPO("hormigon.adiciones.tipo","Adiciones Tipo","Hormigón",22, "Text"),
    HORMIGON_ADICIONES_CANTIDAD("hormigon.adiciones.cantidad","Adiciones Cantidad","Hormigón",23, "number"),

    //METEOROLOGIA
    METEOROLOGIA_TEMPERATURA("meteorologia.temperatura","Temperatura ºC","Meteorología",24, "Slider"),
    METEOROLOGIA_HUMEDAD("meteorologia.humedad","Humedad %","Meteorología",25, "Slider"),
    METEOROLOGIA_VELOCIDAD("meteorologia.velocidad","Velocidad Viento","Meteorología",26, "Slider"),

    //HORARIO
    HORARIO_CARGAPLANTA("horario.cargaPlanta","Carga en Planta","Horario",27, "Text"),
    HORARIO_LLEGADAOBRA("horario.llegadaObra","Llegada a obra","Horario",28, "TimePicker"),
    HORARIO_INICIODESCARGA("horario.inicioDescarga","Inicio Descarga","Horario",29, "TimePicker"),
    HORARIO_FINALDESCARGA("horario.finalDescarga","Final de Descarga","Horario",30, "TimePicker"),
    HORARIO_LLEGADAPLANTA("horario.llegadaPlanta","Llegada a Planta","Horario",31, "TimePicker"),
    HORARIO_LIMITEUSO("horario.limiteUso","Límite de Uso","Horario",32, "Text"),
    HORARIO_HORMIGONBOMBEADO("horario.hormigonBombeado","Hormigón ha sido bombeado","Horario",33, "Switch"),
    HORARIO_AGUACLIENTE("horario.aguaCliente","Agua Añadida a obra a petición del cliente","Horario",34, "Number"),


    //HORARIO
    RECEPCION_LABORATORIO("recepcion.laboratorio","Laboratorio","Recepción",35, "Text"),
    RECEPCION_ELEMENTOHORMIGON("recepcion.elementoHormigon","Elemento Hormigonado","Recepción",36, "Text"),
    RECEPCION_HORATOMA("recepcion.horaToma","Hora de toma","Recepción",37, "TimePicker"),
    RECEPCION_CONO("recepcion.cono","Cono","Recepción",38, "Text"),
    RECEPCION_NUMPROBETAS("recepcion.numProbetas","Nº de probetas","Recepción",39, "Number"),

    ;


    private String name;
	private String displayName;
	private String groupName;
    private Integer index;
    private String editor;




    @JsonIgnore
    public static MetadataAlbaranEnum findByName(String name){
        for(MetadataAlbaranEnum v : values()){
            if( v.name.equals(name)){
                return v;
            }
        }
        return null;
    }


    @JsonIgnore
    public static <T> List<MetadataAlbaranEnum> findByClass(T clase){
        if( clase instanceof AlbaranDto){
            // for(MetadataAlbaranEnum v : values()){
                AlbaranDto dto = (AlbaranDto) clase;
                List<String> campos = dto.getFieldsList();

                campos = campos.stream().filter((c)-> {

                    return !c.equals("cliente")
                    && !c.equals("transporte")
                    && !c.equals("meteorologia")
                    && !c.equals("hormigon");
                }).collect(Collectors.toList());

                campos.addAll(mapPropertiesSubObject(dto.getCliente()));
                campos.addAll(mapPropertiesSubObject(dto.getTransporte()));
                campos.addAll(mapPropertiesSubObject(dto.getMeteorologia()));
                campos.addAll(mapPropertiesSubObject(dto.getHormigon()));
                campos.addAll(mapPropertiesSubObject(dto.getHorario()));
                campos.addAll(mapPropertiesSubObject(dto.getRecepcion()));

                //  campos.stream().forEach((cadena)-> {
                //     log.info("parametro {}", cadena);
                // });

                MetadataAlbaranEnum[] metas = values();
                return campos.stream()
                .filter(c -> Stream.of(metas).anyMatch(m -> m.getName().equals(c)))
                .map(c -> {
                    return MetadataAlbaranEnum.findByName(c) ;
                })
                .collect(Collectors.toList());
            // }
        }
        return null;
    }

    private static List<String> mapPropertiesSubObject(BaseDto dto) {
        return dto.getFieldsList().stream()
        .map(f -> dto.getClass().getSimpleName().toLowerCase().replace("dto","").concat(".").concat(f))
        .collect(Collectors.toList());
    }

}