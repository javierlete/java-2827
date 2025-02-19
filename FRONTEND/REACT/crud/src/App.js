import { BrowserRouter, Route, Routes } from 'react-router';
import './App.css';
import Cabecera from './componentes/Cabecera';
import Formulario from './componentes/Formulario';
import Listado from './componentes/Listado';
import Pie from './componentes/Pie';
import Principal from './componentes/Principal';
import { servicio } from './servicios/ProductoServicio';

function App() {
  const productos = servicio.obtenerProductos();

  return (
    <BrowserRouter>
      <Cabecera />
      <main className="container my-3">
        <Routes>
          <Route path="/" element={<Principal productos={productos} />} />
          <Route path="/listado" element={<Listado />} />
          <Route path="/formulario" element={<Formulario />} />
        </Routes>
      </main>
      <Pie />
    </BrowserRouter>
  );
}

export default App;
