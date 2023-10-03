export interface IVehiculo {
  matricula: string;
}

export class Vehiculo implements IVehiculo {
  static [Symbol.hasInstance](obj: { matricula: any; }): boolean {
    if ( obj.matricula) {
        return true;
    }
    return false;
  }

  matricula!: string;
}

export class Camion extends Vehiculo implements IVehiculo  {
  static [Symbol.hasInstance](obj: any): boolean {
    if (obj && obj.matricula) {
      return true;
    }
    return false;
  }
}

export class Remolque extends Vehiculo implements IVehiculo  {
  static [Symbol.hasInstance](obj: any): boolean {
    if (obj && obj.matricula) {
      return true;
    }
    return false;
  }
}

