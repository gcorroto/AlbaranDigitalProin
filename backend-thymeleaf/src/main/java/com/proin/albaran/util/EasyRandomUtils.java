package com.proin.albaran.util;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.HashMap;
import java.util.List;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.CityRandomizer;
import org.jeasy.random.randomizers.CompanyRandomizer;
import org.jeasy.random.randomizers.FirstNameRandomizer;
import org.jeasy.random.randomizers.FullNameRandomizer;
import org.jeasy.random.randomizers.GenericStringRandomizer;
import org.jeasy.random.randomizers.IsbnRandomizer;
import org.jeasy.random.randomizers.RegularExpressionRandomizer;
import org.jeasy.random.randomizers.WordRandomizer;


/**
 * The Class EasyRandomUtils.
 */
public class EasyRandomUtils {

  /**
     * Generate easy random.
     *
     * @return the easy random
     */
    public static EasyRandom generateEasyRandom() {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
				.stringLengthRange(3, 10)
                .objectPoolSize(10)
                .randomizationDepth(10)
                .charset(UTF_8)
                .overrideDefaultInitialization(true)
                .stringLengthRange(10, 20)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .ignoreRandomizationErrors(true);
        return new EasyRandom(parameters);
    }

	public static RegularExpressionRandomizer cifGenerator() {
		return EasyRandomCifUtils.realCifGenerator();
	}


	public static RegularExpressionRandomizer matriculaGenerator() {
		return new RegularExpressionRandomizer("[0-9]{4}([BCDFGHJKLMNPRSTVWXYZ]{3})");
	}

    public static FirstNameRandomizer nombreGenerator() {
		return new FirstNameRandomizer();
	}

    public static FullNameRandomizer nombreCompletoGenerator() {
		return new FullNameRandomizer();
	}

    public static CityRandomizer ciudadGenerator() {
		return new CityRandomizer();
	}

  public static CompanyRandomizer companiaGenerator() {
		return new CompanyRandomizer();
	}

  public static RegularExpressionRandomizer modeloHormigonGenerator(){
    return new RegularExpressionRandomizer("[A-Z]{3} (I|II|II)/[A-Z]{1}-[A-Z]{1}[0-9]{2}[.][0-9]{1} [A-Z]{1}");
  }

  public static IsbnRandomizer numeroIsbnGenerator() {
		return new IsbnRandomizer();
	}

  public static WordRandomizer stringGenerator(long longitud) {
		return new WordRandomizer(longitud);
	}

  public static GenericStringRandomizer catalogoRandomGenerator(List<String> catalogo) {
		return new GenericStringRandomizer(catalogo.toArray(new String[0]));
	}

}