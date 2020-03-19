<#import "parts/common.ftl" as c>

<@c.page>
    <h1 xmlns="http://www.w3.org/1999/html">User editor</h1>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form action="save" method="post">
                <div class="form-group row">
                    <label><input type="checkbox" name="userEnable" class="form-check-label"
                                  <#if user.isActive()>checked</#if> >Active</label>
                </div>
                <input type="hidden" value="${user.id} " name="userId">
                <div class="form-group row">
                    <input type="text" value="${user.username}" name="username" class="form-control mr-2">
                </div>
                <#list roles as role>
                    <div class="form-group row">
                        <label><input type="checkbox" class="form-check-label"
                                      name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                        </label>
                    </div>
                </#list>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>

            </br>

            <div class="form-group row col-sm">
                <form action="resetpwd" method="post">
                    <input type="hidden" value="${user.id} " name="userId">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Reset password</button>
                </form>

                <form action="delete" method="post">
                    <input type="hidden" value="${user.id} " name="userId">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary ml-3">Delete user</button>
                </form>
            </div>

        </div>
    </div>
</@c.page>