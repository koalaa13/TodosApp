<#-- @ftlvariable name="todosList" type="ru.ifmo.todosApp.domain.TodosList" -->
<#-- @ftlvariable name="todoCredentials" type="ru.ifmo.todosApp.form.TodoCredentials" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if todosList??>
        <div class="todos-list-info">
            <h1>You have ${todosList.todos?size} todos in this list</h1>
            <div class="add-todo form-box">
                <div class="header">
                    Create a new todo.
                </div>
                <div class="body">
                    <form method="post" action="createTodo">
                        <div class="field">
                            <div class="name">
                                <label for="title">Todo title</label>
                            </div>
                            <div class="value">
                                <input id="title" name="title" value=${todoCredentials.title!}>
                            </div>
                        </div>
                        <div class="field">
                            <div class="name">
                                <label for="content">Todo content</label>
                            </div>
                            <div class="value">
                                <input id="content" name="content" value=${todoCredentials.content!}>
                            </div>
                        </div>
                        <div class="button-field">
                            <input type="submit" value="Create todo">
                        </div>
                    </form>
                </div>
            </div>
            <#list todosList.todos as todo>
                <div class="todo-info">
                    <div class="title">${todo.title}</div>
                    <div class="content">${todo.content}</div>
                    <#if !todo.done>
                        <form class="todo-done" method="post" action="todoDone">
                            <input type="hidden" name="todoId" value="${todo.id}">
                            <input type="submit" class="todo-done-button" value="I did it!">
                        </form>
                    </#if>
                </div>
            </#list>
        </div>
    <#else>
        <h1>No such list.</h1>
    </#if>
</@c.page>
