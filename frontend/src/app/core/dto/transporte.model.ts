import { Camion, IVehiculo, Remolque } from "./vehiculo.model";

export interface ITransporte {
  empresa: string;
	cif: string;
  camion: IVehiculo;
	remolque: IVehiculo;
  cargadorContractual: string;
}

export class Transporte implements ITransporte {
  static [Symbol.hasInstance](obj) {
    if ( obj.camion || obj.remolque) {
        return true;
      }
  }
  empresa: string;
	cif: string;
  camion: Camion;
  remolque: Remolque;
  cargadorContractual: string;
}

