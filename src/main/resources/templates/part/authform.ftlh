<#macro authform path name >
<form action=${path} method="post">
    Логин: <input type = "text"  name = "login" >
    </br>
    Пароль: <input type = "text"  name = "pasword" >
    <input type = "submit" value = ${name} >
</form>
</#macro>