const API = "/api/amigurumis"; 

document.addEventListener("DOMContentLoaded", cargarAmigurumis);

// Cargar lista
async function cargarAmigurumis() {
    const res = await fetch(API);
    const lista = await res.json();

    const tabla = document.getElementById("tabla-amigurumis");
    tabla.innerHTML = "";

    lista.forEach(a => {
        tabla.innerHTML += `
            <tr>
                <td>${a.id}</td>
                <td>${a.descripcion}</td>
                <td>${a.precio}</td>
                <td>${a.categoria?.nombre || 'Sin categoría'}</td>
                <td>
                    <button class="btn btn-warning btn-sm" onclick="editar(${a.id})">Editar</button>
                    <button class="btn btn-danger btn-sm ms-2" onclick="eliminar(${a.id})">Eliminar</button>
                </td>
            </tr>
        `;
    });
}

// Enviar formulario
document.getElementById("amigurumi-form").addEventListener("submit", async e => {
    e.preventDefault();

    const id = document.getElementById("id").value;

    const amigurumi = {
        descripcion: document.getElementById("descripcion").value,
        precio: parseFloat(document.getElementById("precio").value),
        categoria: { id: parseInt(document.getElementById("categoriaId").value) }
    };

    const metodo = id ? "PUT" : "POST";
    const url = id ? `${API}/${id}` : API;

    await fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(amigurumi)
    });

    resetForm();
    cargarAmigurumis();
});

// Editar
async function editar(id) {
    const res = await fetch(`${API}/${id}`);
    const a = await res.json();

    document.getElementById("form-title").innerText = "Editar Amigurumi";
    document.getElementById("id").value = a.id;
    document.getElementById("descripcion").value = a.descripcion;
    document.getElementById("precio").value = a.precio;
    document.getElementById("categoriaId").value = a.categoria?.id || "";
}

// Eliminar
async function eliminar(id) {
    await fetch(`${API}/${id}`, { method: "DELETE" });
    cargarAmigurumis();
}

// Reset
function resetForm() {
    document.getElementById("form-title").innerText = "Agregar Amigurumi";
    document.getElementById("amigurumi-form").reset();
    document.getElementById("id").value = "";
}
