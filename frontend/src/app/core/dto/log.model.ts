export interface ILog {
  level: string;
  message: string;
}

export class Log implements ILog {
  static [Symbol.hasInstance](obj: { level: any; }): boolean {
    if ( obj.level) {
        return true;
    }
    return false;
  }
  level!: string;
  message!: string;
}

