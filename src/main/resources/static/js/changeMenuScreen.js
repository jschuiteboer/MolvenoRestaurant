//Define Endpoints
var _restEndpoint = '/api/dishes/';
var _secondEndpoint = '/api/ingredients/';

var _deleteElement = $('#btndelete');
var _secondDeleteElement = $('#secondDelete')

//Define Table
var _dishTableElement = $('#dishTable');

// Define Modal
var _dishModalElement = $('#dishModal');
var _ingredientModalElement = $('#addIngredientModal');

// Define add Dish and ingredient button
var _dishButton = $('#addDishBtn');
var _ingredientButton = $('#addIngredientBtn');
var _addIngredientBtn = $('#btnIngredient');

var _DishDataTable = _dishTableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});

_dishModalElement.find('#ingredientTable').DataTable({
    paging: false,
    searching: false
});



_ingredientButton.on('click', function(){
    openModalForIngredients({},true);
});

_dishButton.on('click', function(){
    openModalForObject({},true);
});


_dishTableElement.on('click', 'tr', function () {
    var data = _DishDataTable.row(this).data();

    if(!data) {
        console.error('unable to retrieve data');
        return;
    }

    $.get(_restEndpoint + data.id, function(data) {
        if(!data) return;

        openModalForObject(data, false);
    });
});

//Open Modal for add ingredient
function openModalForIngredients(ingredient, newEntry){

    if(newEntry){
        _ingredientModalElement.find('#modal-title').html('Add ingredient to Dish');
    }else{
        _ingredientModalElement.find('#modal-title').html('Edit ingredient');
    }

    if(newEntry){
        _secondDeleteElement.hide();
    }else{
        _secondDeleteElement.show();
    }

    //Put the JSON for ingredientName in the dropdown
    $.getJSON(_secondEndpoint, function(result){
        var dropdown = $('#ingredientDropdown');
        dropdown.empty();
        $.each(result, function() {
            dropdown.append($("<option />").val(this.id).text(this.ingredientName));
        });
    });

    _ingredientModalElement.find('#btnIngredient')
    .off('click')
    .on('click', function(){
        var _dishIngredientListField = _ingredientModalElement.find('#ingredientDropdown');
        var _dishIngredientQuantityField = _ingredientModalElement.find('#quantity')

        var ingredient = {
            id: _dishIngredientListField.val(),
            stock: _dishIngredientQuantityField.val(),
        };

        var _ingredientTable = _dishModalElement.find('#ingredientTable').DataTable();
        _ingredientTable.row.add(ingredient);
        _ingredientTable.draw();

        _ingredientModalElement.modal('hide');
    });

    _ingredientModalElement.modal('show');

}

//Open the Dish Modal
function openModalForObject(dish,newEntry) {
    var _nameField = _dishModalElement.find('#name');
    var _priceField = _dishModalElement.find('#price');
    var _descriptionField = _dishModalElement.find('#description');
    var _categoryField = _dishModalElement.find('#category');


    if(!newEntry){
        _nameField.val(dish.name);
        _priceField.val(dish.price);
        _descriptionField.val(dish.description);
        _categoryField.val(dish.category);
    }else{
        _nameField.val("");
        _priceField.val("");
        _descriptionField.val("");
        _categoryField.val("");
        var _ingredientDataTable = $('#ingredientTable').DataTable();
        _ingredientDataTable.clear().draw();
    }

    if(newEntry){
        _dishModalElement.find('#modal-title').html('New Dish')
    }else{
        _dishModalElement.find('#modal-title').html('Edit Dish');
    }

    if(!newEntry){
        var _ingredientTable = _dishModalElement.find('#ingredientTable').DataTable();
        _ingredientTable.clear();
        _ingredientTable.rows.add(dish.ingredientList);
        _ingredientTable.draw();
    }

    _dishModalElement.find('#btnsubmit')
    .off('click')
    .on('click', function() {

        if(newEntry){
            var saveData = {
                name: _nameField.val(),
                price: _priceField.val(),
                description: _descriptionField.val(),
                category: _categoryField.val()
            };
        }else{
            var saveData = {
                id: dish.id,
                name: _nameField.val(),
                price: _priceField.val(),
                description: _descriptionField.val(),
                category: _categoryField.val()
            };
        }



        $.ajax({
            contentType : 'application/json',
            url: _restEndpoint,
            type: 'post',
            data: JSON.stringify(saveData),
            success: function() {
                _dishModalElement.modal('hide');
                reloadData();
            },
        });
    });

    if(!newEntry){
        _dishModalElement.find('#btndelete').show()
        .off('click')
        .on('click', function() {
            var result = confirm('this action can not be undone');

            if(result) {
                $.ajax({
                    contentType : 'application/json',
                    url: _restEndpoint + dish.id,
                    type: 'delete',
                    success: function() {
                        _dishModalElement.modal('hide');
                        reloadData();
                    },
                });
            }
        });
    }
    _dishModalElement.modal('show');
    if(newEntry){
        _deleteElement.hide();
    }else{
        _deleteElement.show();
    }
}

function reloadData() {
    _DishDataTable.ajax.reload();
}
