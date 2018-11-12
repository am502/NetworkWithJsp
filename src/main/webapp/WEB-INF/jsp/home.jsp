<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 12.11.18
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather</title>
</head>
<body>
<form method="post" action="weather">
    <input placeholder="City" type="text" name="city"/>

    <select name="day">
        <option value="1">На сегодня</option>
        <option value="2">На завтра</option>
        <option value="3">На послезавтра</option>
        <option value="4">Через 2 дня</option>
        <option value="5">Через 3 дня</option>
        <option value="6">Через 4 дня</option>
        <option value="7">Через 5 дней</option>
    </select>
    <select name="units">
        <option value="M">Celsius</option>
        <option value="I">Fahrenheit</option>
        <option value="S">Kelvin</option>
    </select>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
