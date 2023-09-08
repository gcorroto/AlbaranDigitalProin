export interface IRecepcion {
  laboratorio: string;
  elementoHormigon: string;
	horaToma: string;
  cono: string;
  numProbetas: number;
}

export class Recepcion implements IRecepcion {
  static [Symbol.hasInstance](obj) {
    if ( obj.laboratorio) {
        return true;
      }
  }

  laboratorio: string;
  elementoHormigon: string;
	horaToma: string;
  cono: string;
  numProbetas: number;
}

