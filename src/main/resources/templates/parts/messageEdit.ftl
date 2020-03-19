<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Message edit
</a>
<div class="collapse <#if message??>show</#if>" id="collapseExample">
    <div class="form-group">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group mt-3">
                <input type="text" name="text" placeholder="Введите сообщение"
                       value="<#if message??>${message.text}</#if>"
                       class="form-control ${(textError??)?string('is-invalid', '')}"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" name="tag" placeholder="Тэг"
                       value="<#if message??>${message.tag}</#if>"
                       class="form-control ${(tagError??)?string('is-invalid', '')}"/>
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile"/>
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save message</button>
            </div>
        </form>
    </div>
</div>
