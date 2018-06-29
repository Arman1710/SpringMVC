<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<html:messages id="title_err" property="title_err">
    <div style="color:red">
        <bean:write name="title_err"/>
    </div>
</html:messages>
<html:messages id="brief_err" property="brief_err">
    <div style="color:red">
        <bean:write name="brief_err"/>
    </div>
</html:messages>

<html:messages id="content_err" property="content_err">
    <div style="color:red">
        <bean:write name="content_err"/>
    </div>
</html:messages>