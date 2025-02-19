import { NavLink } from "react-router";

export default function Cabecera() {
    return (<nav className="navbar navbar-expand-lg bg-dark sticky-top" data-bs-theme="dark">
        <div className="container-fluid">
            <NavLink className="navbar-brand" to="/">Productos</NavLink>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink className="nav-link" to="/listado">Administración</NavLink>
                    </li>
                </ul>
            </div>
        </div>
    </nav>);
}