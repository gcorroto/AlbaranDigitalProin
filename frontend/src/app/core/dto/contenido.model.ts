import { DesgloseContenido, IDesgloseContenido } from "@dto/desglose-contenido.model";

export interface IContenido {
  cementos: IDesgloseContenido[];
  aditivos: IDesgloseContenido[];
  adiciones: IDesgloseContenido[];
}

export class Contenido implements IContenido {
  static [Symbol.hasInstance](obj) {
    if ( obj.cementos | obj.aditivos  | obj.adiciones ) {
        return true;
      }
  }
  cementos: DesgloseContenido[];
  aditivos: DesgloseContenido[];
  adiciones: DesgloseContenido[];
}

