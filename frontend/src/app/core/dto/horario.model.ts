export interface IHorario {
  cargaPlanta: string;
  llegadaObra: string;
	inicioDescarga: string;
  finalDescarga: string;
  llegadaPlanta: string;
  limiteUso: string;
  hormigonBombeado: string;
  aguaCliente: string;
}

export class Horario implements IHorario {
  static [Symbol.hasInstance](obj) {
    if ( obj.llegadaObra) {
        return true;
      }
  }

  cargaPlanta: string;
  llegadaObra: string;
	inicioDescarga: string;
  finalDescarga: string;
  llegadaPlanta: string;
  limiteUso: string;
  hormigonBombeado: string;
  aguaCliente: string;
}

