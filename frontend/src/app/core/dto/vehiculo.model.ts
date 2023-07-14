export interface IVehiculo {
  matricula: string;
}

export class Vehiculo implements IVehiculo {
  static [Symbol.hasInstance](obj) {
    if ( obj.matricula) {
        return true;
      }
  }

  matricula: string;
}

export class Camion extends Vehiculo implements IVehiculo  {
  static [Symbol.hasInstance](obj) {
    if ( obj.matricula) {
        return true;
      }
  }

  matricula: string;
}

export class Remolque extends Vehiculo implements IVehiculo  {
  static [Symbol.hasInstance](obj) {
    if ( obj.matricula) {
        return true;
      }
  }

  matricula: string;
}

