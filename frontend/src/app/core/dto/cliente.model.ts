export interface ICliente {
  nombre: string;
  id: string;
	cif: string;
}

export class Cliente implements ICliente {
  static [Symbol.hasInstance](obj) {
    if ( obj.nombre) {
        return true;
      }
  }

  nombre: string;
  id: string;
	cif: string;
}

