import Ficha from "./Ficha";

export default function Principal() {
    const fichas = [];

    for (let i = 0; i < 10; i++) {
        fichas.push(<Ficha key={i} />);
    }

    return (
        <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
            {fichas}
        </div>
    );
}