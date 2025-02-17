function MyButton() {
    function handleClick() {
        alert('Click');
    }

    return (
        <button onClick={handleClick}>
            Pulsado
        </button>
    );
}

function MyApp() {
    return (
        <div>
            <h1>Welcome to my app</h1>
            <MyButton />
        </div>
    );
}

// Renderiza el componente App en el elemento con id "root"
ReactDOM.render(<MyApp />, document.getElementById('root'));