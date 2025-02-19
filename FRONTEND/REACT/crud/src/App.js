import './App.css';
import Cabecera from './componentes/Cabecera';
import Formulario from './componentes/Formulario';
import Listado from './componentes/Listado';
import Pie from './componentes/Pie';
import Principal from './componentes/Principal';

function App() {
  return (
    <>
    <Cabecera />
    <main className="container my-3">
      <Principal />
      <Listado />
      <Formulario />
    </main>
    <Pie />
    </>
  );
}

export default App;
