
import { EntityToPath } from "../const/Enums";
import { EntityApi } from "../const/types";

export function getUrlWithPath<T>(t:T) {
  const apiPath:EntityApi = EntityToPath[t['name']];
  return `https://swapi.dev/api/${apiPath}`;
}
