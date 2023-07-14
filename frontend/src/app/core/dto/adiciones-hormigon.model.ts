export interface IAdicionesHormigon {
  tipo: string;
  cantidad: number;
}

export class AdicionesHormigon implements IAdicionesHormigon {
  static [Symbol.hasInstance](obj) {
    if ( obj.cantidad) {
        return true;
      }
  }
  tipo: string;
  cantidad: number;
}

