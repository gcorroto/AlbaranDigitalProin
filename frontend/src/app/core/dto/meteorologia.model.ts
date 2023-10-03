export interface IMeteorologia {
  temperatura: number;
  humedad?: number;
	velocidad?: number;
}

export class Meteorologia implements IMeteorologia {
  static [Symbol.hasInstance](obj: { temperatura: any; }) {
    if ( obj.temperatura) {
        return true;
    }
    return false;
  }

  temperatura!: number;
  humedad?: number;
	velocidad?: number;
}

