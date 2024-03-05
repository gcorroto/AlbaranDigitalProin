import { Cliente, ICliente } from "@dto/cliente.model";
import { Hormigon, IHormigon } from "@dto/hormigon.model";
import { IMeteorologia, Meteorologia } from "@dto/meteorologia.model";
import { ITransporte, Transporte } from "@dto/transporte.model";
import { Horario } from "@dto/horario.model";
import { Recepcion } from "@dto/recepcion.model";

export interface IAlbaran {
   numeroAlbaran: string;
	 fechaAlbaran?: string;
	 distanciaADestino?: number;
	 m3v?: number;
	 progresoDia?: number;
	 codigoPlanta?: string;
	 centro?: number;
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

export interface LineaAlbaranDto {
    tipoMaterial?: string;
    descripcion?: string;
    cantidad?: number;
    //unidadCantidad: Consider defining a type or interface for this
    sello?: string;
    entidadCertificadora?: string;
    logotipo?: string;
    cantidadSolicitadaPedido?: number;
    unidadCantidadSolicitadaPedido?: string;
    cantidadServidaDia?: number;
    unidadCantidadServidaDia?: string;
}

export class Albaran {
    static [Symbol.hasInstance](obj: { numeroAlbaran: any; }) {
      if ( obj.numeroAlbaran) {
          return true;
      }
      return false;
    }

    // Pestaña cabecera
    especificacion?: string;
    volumenTotalFabricado?: number;
    unidadVolumenTotalFabricado?: string;
    masaTotalFabricada?: number;
    unidadMasaTotalFabricada?: string;
    descripcionCementoAlbaran?: string;
    masaCementiciaReal?: number;
    unidadMasaCementiciaReal?: string;
    nombreProveedorCementoAlbaran?: string;
    relacionAguaCementoReal?: number;
    serie?:string;

    // Pestaña de cliente
    numeroAlbaran?: string;
    fecha?: Date;
    unidadDistanciaADestino?: string;
    distanciaADestino?: number;
    codigoPlanta?: string;
    centro?: string;
    nombreCliente?: string;
    cliente?: string;
    nombreObra?: string;
    obra?: string;

    // Pestaña de transporte
    nombreOperadorTransporte?: string;
    cifOperadorTransporte?: string;
    matriculaCamion?: string;
    matricularemolque?: string;
    nombreTransportista?: string;
    cifTransportista?: string;
    clienteEsCargadorContractual?: boolean;

    // Pestaña de hormigones
    lineasAlbaran?: LineaAlbaranDto[]; // Array of LineaAlbaranDto objects

    // Pestaña meteorología
    clima?: string;
    direccionViento?: string;
    fechaCreacion?: Date;
    humedad?: string;
    intensidadPrecipitacion?: string;
    presion?: string;
    prevision?: string;
    razonesClima?: string;
    temperatura?: string;
    velocidadViento?: string;

    // Pestaña Horarios
    fechaAlbaran?: Date;
    llegadaobra?: Date;
    iniciodescarga?: Date;
    salidaobra?: Date;
    llegadaplanta?: Date;
}

export class AlbaranOLD implements IAlbaran {
  static [Symbol.hasInstance](obj: { numeroAlbaran: any; }) {
    if ( obj.numeroAlbaran) {
        return true;
    }
    return false;
  }

  numeroAlbaran!: string;
  fechaAlbaran?: string;
  distanciaADestino?: number;
  m3?: number;
  progresoDia?: number;
  codigoPlanta?: string;
  centro?: number;
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

