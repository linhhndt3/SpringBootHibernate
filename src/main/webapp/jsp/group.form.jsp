<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Add Group</h1>	
		<form:form method="post" action="/nhom/luu">
			<p>
				<form:input type="text" path="name" name="name"/>
			</p>
			<p class="submit">
				<input type="submit" name="add" value="Add">
			</p>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>