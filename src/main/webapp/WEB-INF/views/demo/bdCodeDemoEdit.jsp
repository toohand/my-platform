<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="
Expression pageContext is undefined on line 5, column 27 in JspEditTemplate.tld.
The problematic instruction:
----------
==> ${pageContext.request.contextPath} [on line 5, column 25 in JspEditTemplate.tld]
----------

Java backtrace for programmers:
----------
freemarker.core.InvalidReferenceException: Expression pageContext is undefined on line 5, column 27 in JspEditTemplate.tld.
	at freemarker.core.TemplateObject.assertNonNull(TemplateObject.java:124)
	at freemarker.core.TemplateObject.invalidTypeException(TemplateObject.java:134)
	at freemarker.core.Dot._getAsTemplateModel(Dot.java:78)
	at freemarker.core.Expression.getAsTemplateModel(Expression.java:89)
	at freemarker.core.Dot._getAsTemplateModel(Dot.java:74)
	at freemarker.core.Expression.getAsTemplateModel(Expression.java:89)
	at freemarker.core.Expression.getStringValue(Expression.java:93)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:76)
	at freemarker.core.Environment.visit(Environment.java:209)
	at freemarker.core.MixedContent.accept(MixedContent.java:92)
	at freemarker.core.Environment.visit(Environment.java:209)
	at freemarker.core.Environment.process(Environment.java:189)
	at freemarker.template.Template.process(Template.java:237)
	at com.lefthand.base.bdcode.builder.BaseCodeBuilder.buildFile(BaseCodeBuilder.java:137)
	at com.lefthand.base.bdcode.builder.BaseCodeBuilder.buildCode(BaseCodeBuilder.java:110)
	at com.lefthand.base.bdcode.builder.BaseCodeBuilder.buildCode(BaseCodeBuilder.java:95)
	at com.lefthand.base.bdcode.builder.BuilderFactory.build(BuilderFactory.java:61)
	at com.lefthand.base.bdcode.builder.BuilderFactory.build(BuilderFactory.java:44)
	at com.lefthand.buildcode.Build.runBuilder(Build.java:63)
	at com.lefthand.buildcode.Build.main(Build.java:69)
