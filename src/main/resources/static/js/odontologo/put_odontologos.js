window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_odontologos_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault()
        console.log(event);
        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = 'http://localhost:8080/odontologos';
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
        setTimeout(()=>{location.reload()},500)
    })
})

//Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
//se encarga de llenar el formulario con los datos del estudiante
//que se desea modificar
function findBy(id) {
    const url = 'http://localhost:8080/odontologos' + "/" + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let odontologo = data;
            document.querySelector('#odontologo_id').value = odontologo.id;
            document.querySelector('#nombre').value = odontologo.nombre;
            document.querySelector('#apellido').value = odontologo.apellido;
            document.querySelector('#matricula').value = odontologo.matricula;

            //el formulario por default esta oculto y al editar se habilita
            document.querySelector('#div_odontologos_updating').style.display = "block";
        }).catch(error => {
            alert("Error: " + error);
        })
}