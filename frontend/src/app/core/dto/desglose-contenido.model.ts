export interface IDesgloseContenido {
  fabricante: string;
  modelo?: string;
  cantidad?: string;
}

export class DesgloseContenido implements IDesgloseContenido {
  static [Symbol.hasInstance](obj: { fabricante: any; }) {
    if ( obj.fabricante) {
        return true;
    }
    return false;
  }
  fabricante!: string;
  modelo?: string;
  cantidad?: string;
}

