
// export const tableConfig: DataTableType = {
//   columns: [
//     {title: "First Name", dataProperty: "firstName", sortable: true, filterable: false},
//     {title: "Last Name", dataProperty: "lastName", sortable: true, filterable: true},
//     {title: "Occupation", dataProperty: "occupation", sortable: false, filterable: false},
//     {title: "Branch", dataProperty: "companyBranch", sortable: false, filterable: true},
//   ],
//   rowActions: [
//     {label: "Edit", actionIdToReturn: "edit", logoImageUrl: "...", showOption: (x) => true },
//     {label: "Copy", actionIdToReturn: "copy", logoImageUrl: "...", showOption: (x) => x.completed },
//     {label: "Delete", actionIdToReturn: "delete", logoImageUrl: "...", showOption: (x) => !x.isActive },
//     {label: "Message", actionIdToReturn: "message", logoImageUrl: "...", showOption: (x) => x.permitsMessaging },
//   ],
//   rowsPerPage: 20,
// }

export interface DataTableType  {
  columns: DataTableTypeColumn[],
  rowActions: DataTableTypeRowActions[],
  rowsPerPage: number,
}
export interface DataTableTypeColumn  {
  title: string,
  dataProperty: string,
  sortable: boolean,
  filterable: boolean
}

export interface DataTableTypeRowActions  {
  label: string,
  actionIdToReturn: string,
  logoImageUrl: string,
  showOption: any
}

export interface PageChangeEventType  {
  fromEntry: number,
  toEntry: number
}


export interface RowActionWithData<A>  {
  actionToPerform: string,
  rowData: A
}

