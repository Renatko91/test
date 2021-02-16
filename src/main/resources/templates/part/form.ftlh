<#macro form path>
    <form action=${path} method="post">
        <input type = "text"  name = "user_name">
        <input type = "submit" name = "submit" value = "Отправить">
    </form>
</#macro>