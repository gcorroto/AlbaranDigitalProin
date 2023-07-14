export interface ILog {
  level: string;
  message: string;
}

export class Log implements ILog {
  static [Symbol.hasInstance](obj) {
    if ( obj.nombre) {
        return true;
      }
  }
  level: string;
  message: string;
}

