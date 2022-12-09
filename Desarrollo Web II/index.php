<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php $conection = mysqli_connect("localhost","root","","control");
    if(!$conection){
        echo "No hay conección".mysqli_connect_error();
    } else{
    $consulta = "SELECT * FROM alumnos;";
    $resultado = mysqli_query($conection,$consulta);
    $numrows = mysqli_num_rows($resultado);
    if($numrows==0){
        echo "No hay registros.";
    }else{
        echo "<table>";
        echo "<tr>";
        echo "<th>ID Alumno</th><th>Nombre Alumno</th><th>Apellidos</th><th>Carrera</th><th>Promedio</th> ";
    }
    }
    ?>

</body>
</html>