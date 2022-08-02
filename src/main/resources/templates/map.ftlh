<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Map</title>
    <meta name="description" content="Map" />

</head>
<body>

<iframe width="625" height="730" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"

        src="https://www.openstreetmap.org/export/embed.html?bbox=
            ${(employee.location_longitude?number-0.0141)?c}
            %2C
            ${(employee.location_latitude?number-0.0045)?c}
            %2C
            ${(employee.location_longitude?number+0.0141)?c}
            %2C
            ${(employee.location_latitude?number+0.0045)?c}
            &amp;layer=mapnik&amp;marker=${employee.location_latitude}%2C${employee.location_longitude}"

        style="border: 1px solid black">

</iframe>

</body>
</html>


