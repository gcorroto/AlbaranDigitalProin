import { AdicionesHormigon, IAdicionesHormigon } from "@dto/adiciones-hormigon.model";
import { Contenido, IContenido } from "@dto/contenido.model";

export interface IHormigon {
  tipo?: string;
  referencia: string;
	relacion?: string;
  contenido?: IContenido;
  adiciones?: IAdicionesHormigon;
}

export class Hormigon implements IHormigon {
  static [Symbol.hasInstance](obj: { referencia: any; }): boolean {
    if ( obj.referencia) {
        return true;
    } else {
        return false;
    }
  }

  tipo?: string;
  referencia!: string;
	relacion?: string;
  contenido?: Contenido;
  adiciones?: AdicionesHormigon;
}

