function ProductCategoryRow() {
  return (
    <tr>
      <th colSpan="2">
        La categoría
      </th>
    </tr>
  );
}

function ProductRow() {
  return (
    <tr>
      <td>
        <span style={{ color: 'red' }}>
          El producto
        </span>
      </td>
      <td>1234,56€</td>
    </tr>
  );
}

function ProductTable() {
  return (
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <ProductCategoryRow />
        <ProductRow />
        <ProductRow />
        <ProductRow />
        <ProductCategoryRow />
        <ProductRow />
        <ProductRow />
      </tbody>
    </table>
  );
}

function SearchBar() {
  return (
    <form>
      <input type="text" placeholder="Search..." />
      <label>
        <input type="checkbox" />
        {' '}
        Only show products in stock
      </label>
    </form>
  );
}

function FilterableProductTable() {
  return (
    <div>
      <SearchBar />
      <ProductTable />
    </div>
  );
}

export default function App() {
  return <FilterableProductTable />;
}
