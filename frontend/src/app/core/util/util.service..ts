import { ArrayFilms, ArrayPlanets, ArrayVehicles, Formats, imagesPeople } from "../const/Enums";

export class UtilService {

  static formatQueryParam(format?: Formats):string  {
    return `${format ? `/?format=${format}` : ''}`;
  }

}
