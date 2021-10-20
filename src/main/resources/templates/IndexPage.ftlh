<#-- @ftlvariable name="todosLists" type="ru.ifmo.todosApp.domain.TodosList[]" -->
<#-- @ftlvariable name="newTodosListCredentials" type="ru.ifmo.todosApp.form.TodosListCredentials" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="create-todos-list form-box" xmlns="http://www.w3.org/1999/html">
        <div class="header">
            Create a new todos list.
        </div>
        <div class="body">
            <form method="post" action="createTodosList">
                <div class="field">
                    <div class="name">
                        <label for="title">Todos list title</label>
                    </div>
                    <div class="value">
                        <input type="text" id="title" name="title" value=${newTodosListCredentials.title!}>
                    </div>
                </div>
                <div class="button-field">
                    <input type="submit" value="Create todos list">
                </div>
            </form>
        </div>
    </div>
    <#if todosLists?size == 0>
        <h1>You have no todos yet.</h1>
    <#else>
        <div class="todos-lists-info">
            <#list todosLists as todosList>
                <div class="header">
                    <div class="title">${todosList.title}</div>
                    <a class="see-todos-list-link" href="/todosList?id=${todosList.id}">See todos in list</a>
                    <form class="delete-todos-list" method="post" action="deleteTodosList">
                        <input type="hidden" name="id" value="${todosList.id}">
                        <input type="submit" class="delete-button" value="Delete todos list">
                    </form>
                </div>
                <div class="count-info">There are ${todosList.todos?size} todos in this list</div>
            </#list>
        </div>
    </#if>
</@c.page>
