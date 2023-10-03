

  import { DataTableType } from "src/app/core/components/table/table.component";

  export class UtilTableService<A extends Record<string, unknown>> {
    dinamicTable(body: A): DataTableType {
      const headers = Object.keys(body).map((propReco) => ({
        title: propReco,
        dataProperty: propReco,
        sortable: !!propReco,
        filterable: !!propReco,
      }));
      return {
        columns: headers,
        rowActions: [
          {
            label: "Edit",
            actionIdToReturn: "edit",
            logoImageUrl: defaulturl,
            showOption: () => true,
          },
          {
            label: "Copy",
            actionIdToReturn: "copy",
            logoImageUrl: defaulturl,
            showOption: (x: unknown) => Boolean(x),
          },
          {
            label: "Delete",
            actionIdToReturn: "delete",
            logoImageUrl: defaulturl,
            showOption: (x: unknown) => !Boolean(x),
          },
          {
            label: "Message",
            actionIdToReturn: "message",
            logoImageUrl: defaulturl,
            showOption: (x: unknown) => Boolean(x),
          },
        ],
        rowsPerPage: 20,
      };
    }
  }


export const defaulturl = "data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==";
