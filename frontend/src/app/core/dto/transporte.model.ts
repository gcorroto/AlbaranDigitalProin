import { Camion, IVehiculo, Remolque } from "./vehiculo.model";

export interface ITransporte {
  empresa?: string;
	cif?: string;
  camion?: IVehiculo;
	remolque?: IVehiculo;
  cargadorContractual?: string;
}

export class Transporte implements ITransporte {
  static [Symbol.hasInstance](obj: { camion: any; remolque: any; }) {
    if ( obj.camion || obj.remolque) {
        return true;
    }
    return false;
  }
  empresa?: string;
	cif?: string;
  camion?: Camion;
  remolque?: Remolque;
  cargadorContractual?: string;
}

