import { Cliente, ICliente } from "@dto/cliente.model";
import { Hormigon, IHormigon } from "@dto/hormigon.model";
import { IMeteorologia, Meteorologia } from "@dto/meteorologia.model";
import { ITransporte, Transporte } from "@dto/transporte.model";
import { Horario } from "@dto/horario.model";
import { Recepcion } from "@dto/recepcion.model";

export interface IAlbaran {
   numAlbaran: string;
	 fechaEntrega?: string;
	 radial?: number;
	 m3v?: number;
	 progresoDia?: number;
	 planta?: string;
	 viaCarga?: number;
	 obra?: string;
	 direccion?: string;
	 cp?: string;
	 municipio?: string;
   cliente?: ICliente;
   transporte?: ITransporte;
   meteorologia?: IMeteorologia;
   hormigon?: IHormigon;
   firma?: string;
}

export class Albaran implements IAlbaran {
  static [Symbol.hasInstance](obj: { numAlbaran: any; }) {
    if ( obj.numAlbaran) {
        return true;
    }
    return false;
  }

  numAlbaran!: string;
  fechaEntrega?: string;
  radial?: number;
  m3?: number;
  progresoDia?: number;
  planta?: string;
  viaCarga?: number;
  obra?: string;
  direccion?: string;
  cp?: string;
  municipio?: string;
  cliente?: Cliente;
  transporte?: Transporte;
  meteorologia?: Meteorologia;
  horario?: Horario;
  recepcion?: Recepcion;
  hormigon?: Hormigon;
  firma?: string;
}

