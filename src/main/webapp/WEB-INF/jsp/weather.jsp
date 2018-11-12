<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 12.11.18
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Weather</title>
</head>
<body>
<div class="container">
    <h2>${weatherDto.city} ${weatherDto.date}</h2>
    <table class="table table-bordered">
        <tr>
            <th>Облачность</th>
            <th>Вероятность осадков</th>
            <th>Давление</th>
            <th>Относительная влажность</th>
            <th>Температура</th>
            <th>Описание</th>
            <th>Направление ветра</th>
            <th>Скорость ветра</th>
        </tr>
        <tr>
            <td>${weatherDto.clouds}</td>
            <td>${weatherDto.pop}</td>
            <td>${weatherDto.pressure}</td>
            <td>${weatherDto.relativeHumidity}</td>
            <td>${weatherDto.temperature}</td>
            <td>${weatherDto.weatherDescription}</td>
            <td>${weatherDto.windDirection}</td>
            <td>${weatherDto.windSpeed}</td>
        </tr>
    </table>
</div>
</body>
</html>
