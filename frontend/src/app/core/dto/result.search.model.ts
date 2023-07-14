

export interface IResultSearch<A> {
  count: number
  next: string
  previous: any
  results: A[]
}

export class ResultSearch<A> implements IResultSearch<A> {
  count: number
  next: string
  previous: any
  results: A[]
}

