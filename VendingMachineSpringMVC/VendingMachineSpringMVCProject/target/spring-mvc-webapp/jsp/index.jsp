<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">       
        <style>
            body {
                background-color: linen;
            }

            h1 {
                color: maroon;
                margin-left: 40px;
            }

            #ItemRows{
                position: absolute;
                right: 500px;
                width: 200px;
                border: 3px solid #73AD2;
                padding: 10px;
            }
            /*            #makePurchase{
                            position: sticky;
                            width: 50%;
                            bottom:10px;
                            border: 3px solid #0797c0;
                        }
                        #money{
                            position: absolute;
                            width: 200px;
                            bottom:250px;
                            border: 3px solid #0797c0;
                        }*/

            button {
                background-color: #4CAF50;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                height: border-box;
                width: border-box;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2>Vending Machine</h2>




                <div class="row" >
                    <div class="col-md-6">
                        <div class="mx-auto">

                            <form action="/" method="GET">
                                    
                                <c:forEach items="${allItems}" var="item" >
                                    <button type="button"  class="btn btn-secondary" onclick="itemClicked('${item.getName()}')">
                                        <c:out value="${item.getName()}"/><br/>
                                        <c:out value="${item.getInventory()}"/><br/>
                                        <c:out value="${item.getPennies()}"/><br/>
                                    </button>
                                </c:forEach>
                                 <p>${displayErrorMessage}</p>
                                    
                            </form>

                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mx-auto">

                            <div id="makePurchase">
                                <form action="/VendingMachineSpringMVCProject/" method="POST">    
                                    <button type="submit" id="makePurchase">
                                        Make purchase
                                    </button>
                                    <input type="text" id="itemName" name="itemName" placeholder="item Name" readonly>
                                    <input type="text" id="totalMoney" name="totalMoney" placeholder="Total Put In" readonly> 
                                    <p> </p>
                                    <button id="returnChange">Return Change</button>
                                    <P >your Change is: <br/>
                                        ${returnDollar} 
                                        ${returnQuarter} 
                                        ${returnDime} 
                                        ${returnNickel} 
                                    </P>
                                    
                                    <p>${displayErrorMessage}</p>
                                    
                                </form>
                            </div>


                        </div>
                    </div>
                </div>

                    <div id="money" class="col-md-6">

                        <button type="button" id="dollar" name="dollar" class="btn btn-primary">
                            Add Dollar
                        </button>


                        <button type="button" id="quarter" name="quarter" class="btn btn-primary">
                            Add Quarter
                        </button>


                        <button type="button" id="dime" name="dime" class="btn btn-primary">
                            Add Dime
                        </button>



                        <button type="button" id="nickel" name="nickel" class="btn btn-primary">
                            Add Nickel
                        </button>


                        <input type="hidden" id="total" name="total" >
                    </div>
                </div>
            </div>





            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/vendingMachineJS.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
