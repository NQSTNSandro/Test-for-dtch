<!DOCTYPE html>
<html>
<head>
    <title>Кадастровые участки</title>
</head>
<body>
<h1>Окс</h1><hr>
<h4>Добавьте окс</h4>
<form action="/oks/create" method="post">
    Название объекта <input type="text" name="name"/>
    Принадлежность к кадастровому объекту <input type="text" name="cq"/>
    <input type="submit" value="Добавить окс"/>

</form>
<hr>
<h1>Участки</h1><hr>
<h4>Добавьте участок</h4>
<form action="/regions/create" method="post">
    Размер участка <input type="text" name="size"/>
    Принадлежность к кадастровому объекту <input type="text" name="cq"/>
    <input type="submit" value="Добавить участок"/>
</form>
</body>
</html>