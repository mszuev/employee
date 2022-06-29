<#import "parts/pager.ftlh" as p>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Employee</title>
<#--    <link rel="stylesheet" type="text/css" href="/css/style.css"/>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>


<body>
<div class="container">
<h1>Employee</h1>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

<style>
    .modal-window {
        display: none;
        position: absolute;
        z-index: 100;
        background: #eee;
        padding: 5px;
        border-radius: 1px;
        box-shadow: 2px 2px 5px #000000;

        left: 30%;

        top: 10%;
    }
    .modal-window-close {
        position: absolute;
        font-size: 14px;
        cursor: pointer;
        right: 4px;
        top: -2px;
    }
    .modal-window-title {
        text-align: center;
    }
    .modal-window-content {
        padding: 5px;
    }

    TD, TH {
        padding: 2px; /* Поля вокруг содержимого таблицы */
        border: 1px solid black; /* Параметры рамки */
    }

</style>

<script type="text/javascript">
    function showModal(self) {
        var modal = document.getElementById('modalWindow');
        var iframe = modal.getElementsByTagName('iframe')[0];
        iframe.src = self.href;
        modal.style.display = 'block';
        return false;
    }
</script>
<div id="modalWindow" class="modal-window">
    <div class="modal-window-close" onclick="this.parentNode.style.display='none';">Закрыть</div>
    <div class="modal-window-title"></div>
    <div class="modal-window-content">
        <iframe width="645" height="760" src="about:blank" frameborder="0"></iframe>
    </div>
</div>

<#--<script src="https://mapgl.2gis.com/api/js/v1"></script>-->

<#--<h3>Поиск</h3>-->

<form action="/search" method="post">
    <table border="2px">
        <tr>
            <td>
                <label>Поиск по имени</label>
                <input type="text" name="search">
            </td>

            <td>
                <input type="submit" value="Найти">
            </td>

        </tr>

    </table>
</form>

<br>
<#--<h2>Employee list(employee count : ${employeeSize})</h2>-->
<table border="2px">
    <tr>
        <td>Id</td>
        <td>Имя</td>
        <td>Полное имя</td>
        <td>Email</td>
        <td>Телефон</td>
        <td>Город</td>
        <td>Улица</td>
        <td>Дом</td>

        <td>Показать на карте</td>
    </tr>
    <#list page.content as employee>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.first_name}</td>
            <td>${employee.full_name}</td>
            <td>${employee.email}</td>
            <td>${employee.phone_number}</td>
            <td>${employee.address_city}</td>
            <td>${employee.address_street}</td>
            <td>${employee.address_house}</td>

            <td><a href="${'/map/'+employee.id?c}" onclick="return showModal(this);">Открыть карту</a></td>
        </tr>
    </#list>
</table>

<@p.pager url page />



<#--<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"-->
<#--        src="https://www.openstreetmap.org/export/embed.html?bbox=29.17007446289063%2C59.63026899876238%2C31.46347045898438%2C60.24390088477537&amp;layer=mapnik&amp;marker=59.938504253195234%2C30.3167724609375"-->
<#--        style="border: 1px solid black">-->

<#--</iframe>-->
<#--<br/><small><a href="https://www.openstreetmap.org/?mlat=59.9385&amp;mlon=30.3168#map=10/59.9385/30.3168">Посмотреть более крупную карту</a></small>-->
    </div>
</body>
</html>