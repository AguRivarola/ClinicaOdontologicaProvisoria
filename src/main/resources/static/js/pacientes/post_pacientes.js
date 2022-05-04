const form = document.getElementById("add_new_paciente");

form.addEventListener("submit", function (e) {
    e.preventDefault();
    console.log("submit");
    const url = "http://localhost:8080/pacientes"
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const dni = document.getElementById("dni").value;
    const fechaIngreso = document.getElementById("fechaIngreso").value;
    const calle = document.getElementById("calle").value;
    const numero = document.getElementById("numero").value;
    const localidad = document.getElementById("localidad").value;
    const provincia = document.getElementById("provincia").value;
    const headers = {
        'Content-Type': 'application/json',
        'X-Content-Type-Options': 'nosniff'
    }
    const body = {
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        fechaIngreso: fechaIngreso,
        domicilio: {
            calle: calle,
            numero: numero,
            localidad: localidad,
            provincia: provincia
        }
    }
    fetch(url, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(body)
    }).then(res => {
        console.log("Post");
        res.json();
    }).then(data => {
        console.log(data);
        let successAlert = '<div class="alert alert-success alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong></strong> paciente agregado </div>'

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').style.display = "block";
        //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
        resetUploadForm();
    }).catch(error => {
        console.log("Error");
        let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error intente nuevamente</strong> </div>'

        document.querySelector('#response').innerHTML = errorAlert;
        document.querySelector('#response').style.display = "block";
        //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
        resetUploadForm();
    })

    function resetUploadForm() {
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fechaIngreso').value = "";
        // document.querySelector('#domicilio').value = "";
    }
})