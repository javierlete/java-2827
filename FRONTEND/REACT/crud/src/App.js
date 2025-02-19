import { BrowserRouter, Route, Routes } from 'react-router';
import './App.css';
import Cabecera from './componentes/Cabecera';
import Formulario from './componentes/Formulario';
import Listado from './componentes/Listado';
import Pie from './componentes/Pie';
import Principal from './componentes/Principal';

function App() {
  return (
    <BrowserRouter>
      <Cabecera />
      <main className="container my-3">
        <Routes>
          <Route path="/" element={<Principal />} />
          <Route path="/listado" element={<Listado />} />
          <Route path="/formulario" element={<Formulario />} />
        </Routes>
      </main>
      <Pie />
    </BrowserRouter>
  );
}

export default App;
