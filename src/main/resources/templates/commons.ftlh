<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="errorMessage" type="java.lang.String" -->
<#import "/spring.ftl" as spring/>
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Todos</title>
        <script src="<@spring.url '/js/jquery-3.6.0.min.js'/>"></script>
        <script src="<@spring.url '/js/notify.js'/>"></script>
    </head>
    <body>
    <header>
        <h2>TODOS APP</h2>
    </header>
    <div class="middle">
        <main>
            <#nested/>
        </main>
    </div>
    </body>
    <script>
        $(function () {
            <#if message??>
            $.notify("${message?js_string}", {className: "success", position: "bottom right"});
            </#if>
        })
        $(function () {
            <#if errorMessage??>
            $.notify("${errorMessage?js_string}", {className: "error", position: "bottom right"});
            </#if>
        })
    </script>
    </html>
</#macro>
