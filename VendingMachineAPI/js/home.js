$(document).ready(function () {

    loadItems();
    $('#dollar').click(function(){
      addMoney(1);
    })
    $('#quater').click(function(){
      addMoney(0.25);
    })
    $('#dime').click(function(){
      addMoney(0.10);
    })
    $('#nickel').click(function(){
      addMoney(0.5);
    })

    $('#makePurchase').click(function(){
      var change = $("#change");

      $.ajax(
      {type: "GET",
      url: 'http://localhost:8080/money/' + $('#totalMoney').val() + '/item/' + $('#itemNumber').val(),


      success: function(change) {
        var changeElement = $('#change');
        var changeLeft ='';

        changeLeft = 'quarters: ' + change.quarters + '    ';
        changeLeft += 'dime: ' + change.dimes + '    ';
        changeLeft += 'nickel: ' + change.nickels + '    ';
        changeLeft += 'Pennies: ' + change.pennies;

        changeElement.val(changeLeft);
        addMoney(-amountOfMoney);
        $("#ItemRows").empty();
        loadItems();

      },
      error: function(a,b,c){
        $('#message').val(a.responseJSON.message);
      }

    });


    });

    $("#changeToReturned").click(function(){
      $('#message').val('');
      $('#change').val('');
      $('#totalMoney').val('');
      $('#itemNumber').val('');

    })
  });


function loadItems(){
  var contentRows =$("#ItemRows");
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/items",

    success: function(itemsArray){
      $.each(itemsArray, function(index, items){
        var id = items.id;
        var name = items.name;
        var price = items.price;
        var quantity = items.quantity;



        var row = '<button onclick="itemClickedOn(\''+items.id+'\')">'
              row+= "Id: " + id + '<br>';
              row+= "Name: " +name + '<br>' ;
              row+= "Price: " +price +  '<br>';
              row+= "Quantity: " + quantity+ '<br>';
              row+= '</button>' + '<br>';

              contentRows.append(row);


      });
    },
    error: function(a,b,c){
      alert("Failed");

    }

  });
}
var amountOfMoney = 0;
 function addMoney(moneyToAdd){
   amountOfMoney = amountOfMoney + moneyToAdd;
   $("#totalMoney").val(amountOfMoney);
 }
 function itemClickedOn(id){
   $('#itemNumber').val(id);

}
