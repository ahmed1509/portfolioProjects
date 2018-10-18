/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function itemClicked(name) {
    $("#itemName").val(name);
}

$("returnChange").click(function (){
    $("#show").show();
});



$('#dollar').click(function () {
    addMoney(1);
});
$('#quarter').click(function () {
    addMoney(0.25);
});
$('#dime').click(function () {
    addMoney(0.10);
});
$('#nickel').click(function () {
    addMoney(0.05);
});

function addMoney(amountOfMoney){
    var previosLeftOver= $('#total').val();
    if(isNaN(previosLeftOver) || !previosLeftOver){
        previosLeftOver = 0;
    }
    var totalAmountOfMoney = parseFloat(previosLeftOver) + amountOfMoney;
    var totalMoneyInDecimal = (totalAmountOfMoney).toFixed(2);
    
    $('#totalMoney').val(totalMoneyInDecimal);
    $("#total").val(totalAmountOfMoney);
}

//var amountOfMoney = 0;
//function addMoney(moneyToAdd) {
//    amountOfMoney = amountOfMoney + moneyToAdd;
//    $("#totalMoney").val(amountOfMoney);
//}


//function dollarButtonClicked(dollar){
//    $("#totalMoney").val(dollar)
//}
//
//function nickelButtonClicked(nickeles){
//     $("#totalMoney").val(nickeles)
//}
//
//function dimeButtonClicked(dimes){
//     $("#totalMoney").val(dimes)
//}
//
//function quarterButtonClicked(quarters){
//    $("#totalMoney").val(quarters)
//}
// 











