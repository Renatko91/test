<#macro form path name inptype inpname inpvalue>
    <form action=${path} method="post">
        <input type = ${inptype}  name = ${inpname}  value = ${inpvalue} >
        <input type = "submit" value = ${name} >
    </form>
</#macro>