<#import "parts/common.ftl" as c>

<@c.page>
    <h5>Hello, <b>${user?if_exists}</b> !</h5>
    <div>This is a simple clone of Twitter</div>
</@c.page>