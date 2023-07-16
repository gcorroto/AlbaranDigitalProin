import { Cliente, ICliente } from "@dto/cliente.model";
import { Hormigon, IHormigon } from "@dto/hormigon.model";
import { IMeteorologia, Meteorologia } from "@dto/meteorologia.model";
import { ITransporte, Transporte } from "@dto/transporte.model";

export interface IAlbaran {
   numAlbaran: string;
	 fechaEntrega: string;
	 radial: number;
	 m3: number;
	 progresoDia: number;
	 planta: string;
	 viaCarga: number;
	 obra: string;
	 direccion: string;
	 cp: string;
	 municipio: string;
   cliente: ICliente;
   transporte: ITransporte;
   meteorologia: IMeteorologia;
   hormigon: IHormigon;
   firma: string;
}

export class Albaran implements IAlbaran {
  static [Symbol.hasInstance](obj) {
    if ( obj.numAlbaran) {
        return true;
      }
  }

  numAlbaran: string;
  fechaEntrega: string;
  radial: number;
  m3: number;
  progresoDia: number;
  planta: string;
  viaCarga: number;
  obra: string;
  direccion: string;
  cp: string;
  municipio: string;
  cliente: Cliente;
  transporte: Transporte;
  meteorologia: Meteorologia;
  hormigon: Hormigon;
  firma: string;
}

