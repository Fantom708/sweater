<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <#if message??>
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </#if>
    <h5>
        <div class="mb-3">Add new user</div>
    </h5>
    <@l.login "/registration" true/>
</@c.page>