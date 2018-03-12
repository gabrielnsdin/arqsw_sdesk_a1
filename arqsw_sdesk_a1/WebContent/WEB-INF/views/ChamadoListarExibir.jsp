<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
    	<div class="page-header">
			<h3>Lista de Chamados</h3>
    		<h4>${fila.nome}</h4>
		</div>
        <div class="form-group col-md-10">
	        <table class="table table-striped">
			  <thead>
				  <tr>
				  	<th>ID</th> 
				    <th>Descricao</th> 
				    <th>Status</th>
				    <th>Data de Abertura</th>
				    <th>Data de Fechamento</th>
				    <th>Ação</th>
				  </tr>
			  <thead>
			  <tbody>
			  <c:forEach var="chamado" items="${chamados}">
			  	<tr>
			  		<td><c:out value="${chamado.id}"/></td>
				    <td><c:out value="${chamado.descricao}"/></td>
				    <td><c:out value="${chamado.status}"/></td>
				    <td><c:out value="${chamado.dtAbertura}"/></td>
				    <td><c:out value="${chamado.dtFechamento}"/></td>
				    <td>
				    	<a href="fechar_chamado?id=${chamado.id}" type="button" class="btn btn-danger" >Fechar Chamado</a>
				    </td>
				 </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>