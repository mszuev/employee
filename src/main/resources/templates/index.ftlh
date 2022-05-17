<!DOCTYPE html>
<#--<html lang="en">-->
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Employee1</h1>
<#--<h3>Add Employee to DB</h3>-->
<#--<form action="/add" method="post">-->
<#--    <table border="1px">-->
<#--        <tr>-->
<#--            <td>-->
<#--                <label>Priority</label>-->
<#--                <input type="number" name="priorityId">-->
<#--            </td>-->
<#--            <td>-->
<#--                <label>Description</label>-->
<#--                <input type="text" name="description">-->
<#--            </td>-->
<#--            <td>-->
<#--                <label>Date</label>-->
<#--                <input type="date" name="date">-->
<#--            </td>-->

<#--            <td>-->
<#--                <input type="submit" value="add task">-->
<#--            </td>-->

<#--        </tr>-->

<#--    </table>-->
<#--</form>-->
<br>
<h2>Employee list(employee count : ${employeeSize})</h2>
<table border="3px">
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
    <#list employeeList as employee>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.first_name}</td>
            <td>${employee.full_name}</td>
            <td>${employee.email}</td>
            <td>${employee.phone_number}</td>
            <td>${employee.address_city}</td>
            <td>${employee.address_street}</td>
            <td>${employee.address_house}</td>

            <td><a href="${'/showonmap/'+employee.id}"">Открыть карту</a></td>
        </tr>
    </#list>
</table>
</body>
</html>