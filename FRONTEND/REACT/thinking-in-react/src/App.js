import PropTypes from 'prop-types';
import { useState } from 'react';
function ProductCategoryRow(props) {
  return (
    <tr>
      <th colSpan="2">
        {props.category}
      </th>
    </tr>
  );
}

ProductCategoryRow.propTypes = {
  category: PropTypes.string
};

function ProductRow(props) {
  const name = props.product.stocked ? props.product.name :
    <span style={{ color: 'red' }}>
      {props.product.name}
    </span>;

  return (
    <tr>
      <td>
        {name}
      </td>
      <td>
        {props.product.price}
      </td>
    </tr>
  );
}

ProductRow.propTypes = {
  product: PropTypes.object
};

function ProductTable(props) {
  const rows = [];
  let lastCategory = null;

  props.products.forEach(product => {
    if (
      product.name.toLowerCase().indexOf(
        props.filterText.toLowerCase()
      ) === -1
    ) {
      return;
    }

    if (props.inStockOnly && !product.stocked) {
      return;
    }

    if (product.category !== lastCategory) {
      rows.push(
        <ProductCategoryRow
          category={product.category}
          key={product.category} />
      );
    }

    rows.push(
      <ProductRow
        product={product}
        key={product.name} />
    );

    lastCategory = product.category;
  });

  return (
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        {rows}
      </tbody>
    </table>
  );
}

ProductTable.propTypes = {
  products: PropTypes.array,
  filterText: PropTypes.string,
  inStockOnly: PropTypes.bool
};

function SearchBar(props) {
  return (
    <form>
      <input 
        type="text" 
        placeholder="Search..."
        value={props.filterText} />
      <label>
        <input 
          type="checkbox"
          checked={props.inStockOnly} />
        {' '}
        Only show products in stock
      </label>
    </form>
  );
}

SearchBar.propTypes = {
  filterText: PropTypes.string,
  inStockOnly: PropTypes.bool
};

function FilterableProductTable(props) {
  const [filterText, setFilterText] = useState('');
  const [inStockOnly, setInStockOnly] = useState(false);

  return (
    <div>
      <SearchBar 
        filterText={filterText} 
        inStockOnly={inStockOnly} />
      <ProductTable 
        products={props.products}
        filterText={filterText}
        inStockOnly={inStockOnly} />
    </div>
  );
}

FilterableProductTable.propTypes = {
  products: PropTypes.array
};

const PRODUCTS = [
  { category: "Fruits", price: "$1", stocked: true, name: "Apple" },
  { category: "Fruits", price: "$1", stocked: true, name: "Dragonfruit" },
  { category: "Fruits", price: "$2", stocked: false, name: "Passionfruit" },
  { category: "Vegetables", price: "$2", stocked: true, name: "Spinach" },
  { category: "Vegetables", price: "$4", stocked: false, name: "Pumpkin" },
  { category: "Vegetables", price: "$1", stocked: true, name: "Peas" }
];

export default function App() {
  return <FilterableProductTable products={PRODUCTS} />
}
