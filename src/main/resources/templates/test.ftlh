<html>
<head>
    <script>
        function bindButton() {

            var button = document.getElementById('button');
            var iframe = document.getElementById('iframe');

            button.addEventListener('click', function(e) {

                iframe.src = 'https://cdn.soft8soft.com/demo/applications/spinner/spinner.html';

            });
        }
    </script>
</head>

<body onload='bindButton()'>
<iframe id='iframe'></iframe>
<button id='button'>Load</button>
</body>
</html>