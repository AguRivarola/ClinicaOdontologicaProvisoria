const form = document.getElementById("add_new_odontologo");

form.addEventListener("submit", function (e) {
    e.preventDefault();
    console.log("submit");
    const url = "http://localhost:8080/odontologos"
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const matricula = document.getElementById("matricula").value;
    const headers = {
        'Content-Type': 'application/json'
    }
    const body = {
        nombre: nombre,
        apellido: apellido,
        matricula: matricula
    }
    fetch(url, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(body)
    }).then(res => {
        console.log("Post");
        res.json();
    }).then(data => {
        let successAlert = '<div class="alert alert-success alert-dismissible">' +
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong></strong> Odontologo agregado </div>'

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
        document.querySelector('#matricula').value = "";
    }
})