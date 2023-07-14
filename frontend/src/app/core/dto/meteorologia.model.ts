export interface IMeteorologia {
  temperatura: number;
  humedad: number;
	velocidad: number;
}

export class Meteorologia implements IMeteorologia {
  static [Symbol.hasInstance](obj) {
    if ( obj.nombre) {
        return true;
      }
  }

  temperatura: number;
  humedad: number;
	velocidad: number;
}

