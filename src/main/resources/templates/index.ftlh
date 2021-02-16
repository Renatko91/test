<#import "part/common.ftlh" as c>
<#import "part/form.ftlh" as f>

<h1>Список сообщений</h1>
<@c.page>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <form action="/delete" method="post">
        <input type="hidden" name="text" value=${message.text} />
        <input type = "submit" value = "Удалить">
    </form>
</div>
<#else>
No message
</#list>
</@c.page>

</br>
<h1>Создать сообщение</h1>
<@f.form "/create">
</@f.form>