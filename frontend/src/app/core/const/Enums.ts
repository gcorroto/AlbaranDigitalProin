
export enum Formats {
  json = 'json',
  wookiee = 'wookiee'
};


export enum ArrayFilms  {
  '',
  '/movies/episodeI.jpg',
  '/movies/episodeII.jpg',
  '/movies/episodeIII.jpg',
  '/movies/episodeIV.jpg',
  '/movies/episodeV.jpg',
  '/movies/episodeVI.jpg',
  '/movies/episodeVII.jpg'
 }

 export enum ArrayPeople  {
  '',
  '/characters/luke.jpg',
  '/characters/cp3o.jpg',
  '/characters/r2d2.jpg',
  '/characters/dart.jpg',
  '/characters/leia.jpg',
  '/characters/owen.jpg',
  '/characters/beru.jpg',
  '/characters/R5-D4.jpg',
  '/characters/Biggs.jpeg',
  '/characters/obi.jpg'
 }

 export const imagesPeople: Record<number, string> = {
   1: '/characters/luke.jpg',
   2: '/characters/cp3o.jpg',
   3: '/characters/r2d2.jpg',
   4: '/characters/dart.jpg',
   5: '/characters/leia.jpg',
   6: '/characters/owen.jpg',
   7: '/characters/beru.jpg',
   8: '/characters/R5-D4.jpg',
   9: '/characters/Biggs.jpeg',
   10: '/characters/obi.jpg',
   12: '/characters/wilhuff.jpg',
   13: '/characters/Chewbacca.jpg',
   14: '/characters/HanSolo.jpg',
   15: '/characters/Greedo.jpg',
   16: '/characters/Jabba.jpg',
   18: '/characters/Wedge.jpg',
   19: '/characters/Jek.jpg',
   81: '/characters/Raymus.jpg',
 } as const;

 export enum ArrayPlanets  {
  '',
  '/planets/Aldera_City.png',
  '/planets/yavin_iv.jpg',
  '/planets/hoths.jpg',
  '/planets/Dagobah.jpg',
  '/planets/Bespin.png',
  '/planets/Endor.jpg',
  '/planets/Naboo.png',
  '/planets/Coruscant.jpg',
  '/planets/Kamino.png',
  '/planets/Geonosis.jpeg',
 }

 export enum ArrayVehicles {
  '',
  '/vehicles/Sand_Crawler.jpg',
  '/vehicles/T-16_skyhopper.gif',
  '/vehicles/X_34_landspeeder.jpg',
  '/vehicles/TIE_LN_starfighter.jpg',
  '/vehicles/Snowspeeder.jpg',
  '/vehicles/TIE_bomber.jpg',
  '/vehicles/AT_AT.jpg',
  '/vehicles/AT_ST.jpg',
  '/vehicles/Storm_IV_Twin_Pod_cloud_car.jpg',
  '/vehicles/Sail_barge.jpg',
 }

 export enum EntityToPath {
    'Albaran '= 'albaran'
 }

export const BASE_SWAPI_URL = `https://swapi.dev/api`;

export enum EntityApiEnum {
  Albaran = 'albaran'
};
