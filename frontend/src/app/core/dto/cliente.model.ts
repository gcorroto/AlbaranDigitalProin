export interface ICliente {
  nombre: string;
  id?: string;
	cif?: string;
}

export class Cliente implements ICliente {
  static [Symbol.hasInstance](obj: { nombre: any; }) {
    if ( obj.nombre) {
        return true;
    }
    else {
        return false;
    }
  }

  nombre!: string;
  id?: string;
	cif?: string;
}

