export interface IRecepcion {
  laboratorio: string;
  elementoHormigon?: string;
	horaToma?: string;
  cono?: string;
  numProbetas?: number;
}

export class Recepcion implements IRecepcion {
  static [Symbol.hasInstance](obj: { laboratorio: any; }): boolean {
    if ( obj.laboratorio) {
        return true;
    }
    return false;
  }

  laboratorio!: string;
  elementoHormigon?: string;
	horaToma?: string;
  cono?: string;
  numProbetas?: number;
}

