<#import "part/common.ftlh" as c>
<#import "part/form.ftlh" as f>

<h1>Список сообщений</h1>
<@c.page>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <@f.form "/delete" "Удалить" "hidden" "text" "${message.text}">
    </@f.form>
</div>
<#else>
No message
</#list>

</br>
<h1>Создать сообщение</h1>
<@f.form "/create" "Отправить" "text" "text" "">
</@f.form>
</@c.page>