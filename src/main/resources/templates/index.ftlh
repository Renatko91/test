<#import "part/common.ftlh" as c>
<#import "part/form.ftlh" as f>

<h1>Список юзеров</h1>
<@c.page>
<#list users as user>
<div>
    <b>${user.id}</b>
    <span>${user.name}</span>
    <form action="/delete" method="post">
        <input type="hidden" name="del_user" value=${user.name} />
        <input type = "submit" value = "Удалить">
    </form>
    <form action="/update" method="post">
        <input type="hidden" name="del_user" value=${user.name} />
        <input type = "submit" value = "Изменить">
    </form>
</div>
<#else>
No user
</#list>
</@c.page>

</br>
<h1>Отправьте данные</h1>
<@f.form "/create">
</@f.form>