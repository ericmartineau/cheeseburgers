<%--
  Created by IntelliJ IDEA.
  User: ericm
  Date: 11/1/16
  Time: 8:10 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pace's Awesome Game</title>
    <meta name="layout" content="main"/>

</head>

<body>

<body>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">Items <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <g:each in="${gameState.bagItems}">
                <li><a href="#">${it.qty} ${it.itemName}</a></li>
            %{--<g:link action="drop" id="${user.id}" params="[item: it.itemName]">Drop</g:link> | <g:link action="destroy" id="${user.id}" params="[item: it.itemName]">Destroy</g:link></li>--}%
            </g:each>

        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">You have <b>$${gameState.money}</b></a>

    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">Health: ${gameState.health}%</a>

    </li>
</content>

<div id="content" role="main">
    <div class="row">

        <div class="col-sm-4">
            <h2>Actions</h2>
            You can travel to:
            <ul>

                <g:each in="${paths}">
                    <li><g:link controller="game" action="move" params="[direction: it.direction]"
                            id="${user.id}">${it.to.label}: ${it.direction}</g:link></li>
                </g:each>
            </ul>


            <g:if test="${items?.size() > 0}">

            <h2>Items</h2>
            <ul>
                <g:each in="${items}">
                    <li>${it.qty} ${it.itemName} <g:link action="pickUp" params="[roomItemId: it.id]"
                            id="${user.id}">Pick Up</g:link></li>
                </g:each>
            </ul>

            </g:if>
            <g:if test="${otherUsers?.size() > 0}">
                <h2>Other People</h2>
                <ul>

                <g:each in="${otherUsers}">
                    <li>${it.user.username} (Health: ${it.health}% --> <g:link action="attack" id="${user.id}" params="[attackUserId: it.user.id]">Attack</g:link></li>
                </g:each>

                </ul>
            </g:if>
    <hr/>
            <g:include action="${gameState.location}" id="${user.id}" />
        </div>

        <div class="col-sm-8">
            <h1>${location.label}</h1>

            <asset:image width="100%" src="background/${gameState.location}.jpg"/>
        </div>
    </div>
</div>

</body>

</body>
</html>