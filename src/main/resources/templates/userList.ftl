<#import "parts/common.ftl" as c>

<@c.page>
    <h1>List of users</h1>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Role</th>
            <th scope="col">Active</th>
            <th scope="col">Posts</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr <#if !user.active>class="table-secondary"</#if>>
                <td><a href="/user/${user.id}">${user.username}</a></td>
                <td><#list user.roles as role><i>${role}<#sep>, </i></#list></td>
                <td>${user.active?c}</td>
                <td><a href="/user-messages/${user.id}">${user.getPosts()}</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>