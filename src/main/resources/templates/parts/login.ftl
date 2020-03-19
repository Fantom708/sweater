<#include "security.ftl">

<#macro login path isRegesterForm>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> User Name:</label>
            <div class="col-sm-6">
                <input type="text" name="username" placeholder="User name"
                       value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" placeholder="Password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegesterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Password:</label>
                <div class="col-sm-6">
                    <input type="password" name="password2" placeholder="Retype password"
                           class="form-control ${(password2Error??)?string('is-invalid', '')}"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" placeholder="some@some.com"
                           value="<#if user??>${user.email}</#if>"
                           class="form-control ${(emailError??)?string('is-invalid', '')}"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="g-recaptcha" data-sitekey="6LcsutwUAAAAAAWbNjMWb2WtKD4_CFMkA3RldVNj"></div>
                <#if captchaError??>
                    <div class="alert alert-danger" role="alert">
                        ${captchaError}
                    </div>
                </#if>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegesterForm><a href="/registration">Add new user</a></#if>
        <button type="submit" class="btn btn-primary"><#if isRegesterForm>Create<#else>Sign in</#if></button>
    </form>
</#macro>

<#macro logout>
<#--    <#if user??>-->
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#--        <button type="submit" class="btn btn-primary">Sign Out</button>-->
        <button type="submit" class="btn btn-primary"><#if isActive>Sign Out<#else>Log in</#if></button>
<#--        <button type="submit" class="btn btn-primary"><#if user?? && user.active>Sign Out<#else>Log in</#if></button>-->
    </form>
<#--    </#if>-->
</#macro>