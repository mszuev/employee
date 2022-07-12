<#import "parts/pager.ftlh" as p>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

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


    </style>
</head>

<body>
<div class="container-fluid">

    <h1>Employee</h1>

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

    <h5>Найдено записей: ${employeeSize}</h5>

    <#if employeeSize == 0>
        <#else>
            <table class="table table-striped table-sm table-hover">
                <thead>
                <tr>
                    <th scope="col">Имя</th>
                    <th scope="col">Полное имя</th>
                    <th scope="col">Email</th>
                    <th scope="col">Телефон</th>
                    <th scope="col">Город</th>
                    <th scope="col">Улица</th>
                    <th scope="col">Дом</th>
                    <th scope="col">Показать на карте</th>
                </tr>
                </thead>

                <tbody>
                <#list page.content as employee>
                    <tr>
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
                </tbody>
            </table>

            <div class="d-flex justify-content-center">
                <@p.pager url page />
            </div>
    </#if>



</div>
</body>
</html>