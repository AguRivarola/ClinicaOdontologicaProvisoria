window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_pacientes_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault()
        console.log(event);
        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            domicilio: {
                id: 1,
                calle: "prueba",
                numero: "null",
                localidad: "null",
                provincia: "null"
            }
        };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = 'http://localhost:8080/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        fetch(url, settings)
            .then(response => response.json())
            .then(res => { console.log("PUT") })
        setTimeout(() => { location.reload() }, 500)
    })
})

//Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
//se encarga de llenar el formulario con los datos del estudiante
//que se desea modificar
function findBy(id) {
    const url = 'http://localhost:8080/pacientes' + "/" + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let paciente = data;
            document.querySelector('#paciente_id').value = paciente.id;
            document.querySelector('#nombre').value = paciente.nombre;
            document.querySelector('#apellido').value = paciente.apellido;
            document.querySelector('#dni').value = paciente.dni;
            document.querySelector('#fechaIngreso').value = paciente.fechaIngreso;
            // document.querySelector('#domicilio').value = paciente.domicilio;

            //el formulario por default esta oculto y al editar se habilita
            document.querySelector('#div_pacientes_updating').style.display = "block";
        }).catch(error => {
            alert("Error: " + error);
        })
}