package com.proin.albaran.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.randomizers.GenericStringRandomizer;
import org.jeasy.random.randomizers.RegularExpressionRandomizer;


/**
 * The Class EasyRandomUtils.
 */
public class EasyRandomCifUtils {


  private final static List<String> letrasCifList = Arrays.asList("A","B","C","D","E","F","G","H","J","N","P","Q","R","S","U","V","W");
  private final static List<String> catalogoCodigosProvinciaCif = mapaCifProvincias().keySet().stream().collect(Collectors.toList());

  public static RegularExpressionRandomizer realCifGenerator() {
    GenericStringRandomizer randomProv = new GenericStringRandomizer(catalogoCodigosProvinciaCif.toArray(new String[0]));
    GenericStringRandomizer randomLetra= new GenericStringRandomizer(letrasCifList.toArray(new String[0]));
    String letraInit = randomLetra.getRandomValue();
    String prov = randomProv.getRandomValue();
		return new RegularExpressionRandomizer( "["+letraInit+"]" + "["+prov+"]" + "[0-9]{5}([A-Z]|[0-9])");
	}

  public static HashMap<String, String> mapaCifProvincias() {
		HashMap<String, String> mapaProvincias = new HashMap<>();
    mapaProvincias.put("00","No Residente");
    mapaProvincias.put("01","Álava");
    mapaProvincias.put("02","Albacete");
    mapaProvincias.put("03","Alicante");
    mapaProvincias.put("53","Alicante");
    mapaProvincias.put("54","Alicante");
    mapaProvincias.put("04","Almería");
    mapaProvincias.put("05","Ávila");
    mapaProvincias.put("06","Badajoz");
    mapaProvincias.put("07","Islas Baleares");
    mapaProvincias.put("57","Islas Baleares");
    mapaProvincias.put("08","Barcelona");
    mapaProvincias.put("58","Barcelona");
    mapaProvincias.put("59","Barcelona");
    mapaProvincias.put("60","Barcelona");
    mapaProvincias.put("61","Barcelona");
    mapaProvincias.put("62","Barcelona");
    mapaProvincias.put("63","Barcelona");
    mapaProvincias.put("64","Barcelona");
    mapaProvincias.put("65","Barcelona");
    mapaProvincias.put("66","Barcelona");
    mapaProvincias.put("68","Barcelona");
    mapaProvincias.put("09","Burgos");
    mapaProvincias.put("10","Cáceres");
    mapaProvincias.put("11","Cádiz");
    mapaProvincias.put("72","Cádiz");
    mapaProvincias.put("12","Castellón");
    mapaProvincias.put("13","Ciudad Real");
    mapaProvincias.put("14","Córdoba");
    mapaProvincias.put("56","Córdoba");
    mapaProvincias.put("15","La Coruña");
    mapaProvincias.put("70","La Coruña");
    mapaProvincias.put("16","Cuenca");
    mapaProvincias.put("17","Gerona");
    mapaProvincias.put("55","Gerona");
    mapaProvincias.put("67","Gerona");
    mapaProvincias.put("18","Granada");
    mapaProvincias.put("19","Guadalajara");
    mapaProvincias.put("20","Guipúzcoa");
    mapaProvincias.put("71","Guipúzcoa");
    mapaProvincias.put("21","Huelva");
    mapaProvincias.put("22","Huesca");
    mapaProvincias.put("23","Jaén");
    mapaProvincias.put("24","León");
    mapaProvincias.put("25","Lérida");
    mapaProvincias.put("26","La Rioja");
    mapaProvincias.put("27","Lugo");
    mapaProvincias.put("28", "Madrid");
    mapaProvincias.put("78", "Madrid");
    mapaProvincias.put("79", "Madrid");
    mapaProvincias.put("80", "Madrid");
    mapaProvincias.put("81", "Madrid");
    mapaProvincias.put("82", "Madrid");
    mapaProvincias.put("83", "Madrid");
    mapaProvincias.put("84", "Madrid");
    mapaProvincias.put("85", "Madrid");
    mapaProvincias.put("86", "Madrid");
    mapaProvincias.put("87", "Madrid");
    mapaProvincias.put("88", "Madrid");
    mapaProvincias.put("29","Málaga");
    mapaProvincias.put("92","Málaga");
    mapaProvincias.put("93","Málaga");
    mapaProvincias.put("30","Murcia");
    mapaProvincias.put("73","Murcia");
    mapaProvincias.put("31","Navarra");
    mapaProvincias.put("32","Orense");
    mapaProvincias.put("33","Asturias");
    mapaProvincias.put("74","Asturias");
    mapaProvincias.put("34","Palencia");
    mapaProvincias.put("35","Las Palmas");
    mapaProvincias.put("75","Las Palmas");
    mapaProvincias.put("36","Pontevedra");
    mapaProvincias.put("94","Pontevedra");
    mapaProvincias.put("37","Salamanca");
    mapaProvincias.put("38","Santa Cruz de Tenerife");
    mapaProvincias.put("76","Santa Cruz de Tenerife");
    mapaProvincias.put("39","Cantabria");
    mapaProvincias.put("40","Segovia");
    mapaProvincias.put("41","Sevilla");
    mapaProvincias.put("90","Sevilla");
    mapaProvincias.put("91","Sevilla");
    mapaProvincias.put("42","Soria");
    mapaProvincias.put("43","Tarragona");
    mapaProvincias.put("77","Tarragona");
    mapaProvincias.put("44","Teruel");
    mapaProvincias.put("45","Toledo");
    mapaProvincias.put("46","Valencia");
    mapaProvincias.put("96","Valencia");
    mapaProvincias.put("97","Valencia");
    mapaProvincias.put("98","Valencia");
    mapaProvincias.put("47","Valladolid");
    mapaProvincias.put("48","Vizcaya");
    mapaProvincias.put("95","Vizcaya");
    mapaProvincias.put("49","Zamora");
    mapaProvincias.put("50","Zaragoza");
    mapaProvincias.put("99","Zaragoza");
    mapaProvincias.put("51","Ceuta");
    mapaProvincias.put("52","Melilla");

    return mapaProvincias;
	}

}