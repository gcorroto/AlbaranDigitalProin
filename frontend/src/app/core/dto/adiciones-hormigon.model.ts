export interface IAdicionesHormigon {
  tipo?: string;
  cantidad?: number;
}

export class AdicionesHormigon implements IAdicionesHormigon {
  static [Symbol.hasInstance](obj: { cantidad: any; }): boolean {
    if ( obj.cantidad) {
        return true;
    }
    return false;
  }
  tipo?: string;
  cantidad?: number;
}

