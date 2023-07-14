export interface IDesgloseContenido {
  fabricante: string;
  modelo: string;
  cantidad: string;
}

export class DesgloseContenido implements IDesgloseContenido {
  static [Symbol.hasInstance](obj) {
    if ( obj.fabricante) {
        return true;
      }
  }
  fabricante: string;
  modelo: string;
  cantidad: string;
}

