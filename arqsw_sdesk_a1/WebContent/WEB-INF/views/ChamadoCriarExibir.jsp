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
    <title>Criar Chamado</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
    	<div class="page-header">
			<h3>Criar chamado</h3>
		</div>
       
		<div class="form-group col-md-10">
	        
	        <form action="criar_chamado_inserir" method="get">
		        <div class="form-group col-md-6">
	        		<form:errors path="chamado.descricao" cssStyle="color:red"/>
			    	<label for="chamado">Descrição:</label>
			    	<textarea class="form-control" id="descricao" placeholder="Insira um descrição para o chamado" name="descricao"></textarea>
				</div>
				<div class="form-group col-md-6">
                    <label for="fila">Escolha a Fila:</label>
                    <form:errors path="fila.id" cssStyle="color:red"/><br>
                    <select class="form-control" name="id">
                        <option value="0"></option>
                        <c:forEach var="fila" items="${filas}">
                            <option value="${fila.id}">${fila.nome}</option>
                        </c:forEach>
                    </select>
				</div>
	            <div id="actions">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" >Salvar Chamado</button>
	                    <a href="index" class="btn btn-default">Cancelar</a>
	                </div>
       		    </div>
            </form>
		</div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>