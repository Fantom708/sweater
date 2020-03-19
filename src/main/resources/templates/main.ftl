<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" class="form-inline">
                <input type="text" name="filterText" class="form-control mr-2" placeholder="поиск по тексту"
                       value="${filterText?if_exists}"/>
                <input type="text" name="filterTag" class="form-control mr-2" placeholder="поиск по тэгу"
                       value="${filterTag?if_exists}"/>
                <label><input type="checkbox" name="filterOwnMess" class="form-check-label"
<#--                             <#if "${filterOwnMess?if_exists}"> <#if "${filterOwnMess}"=="on">checked</#if></#if>-->
<#--                             <#if "${filterOwnMess}"=="on">checked</#if>-->
                    />Только мои сообщения</label>
                <button type="submit" class="btn btn-primary mt-2 ml-3">Search</button>
            </form>
        </div>
    </div>

    <#include "parts/messageEdit.ftl" />

    <#include "parts/messageList.ftl" />

</@c.page>