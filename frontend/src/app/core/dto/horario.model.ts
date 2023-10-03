export interface IHorario {
  cargaPlanta?: string;
  llegadaObra: string;
	inicioDescarga?: string;
  finalDescarga?: string;
  llegadaPlanta?: string;
  limiteUso?: string;
  hormigonBombeado?: string;
  aguaCliente?: string;
}

export class Horario implements IHorario {
  static [Symbol.hasInstance](obj: { llegadaObra: any; }) {
    if ( obj.llegadaObra) {
        return true;
    }
    return false;
  }

  cargaPlanta?: string;
  llegadaObra!: string;
	inicioDescarga?: string;
  finalDescarga?: string;
  llegadaPlanta?: string;
  limiteUso?: string;
  hormigonBombeado?: string;
  aguaCliente?: string;
}

