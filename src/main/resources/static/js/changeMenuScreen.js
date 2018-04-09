//Define Endpoints
var _restEndpoint = '/api/dishes/';
var _secondEndpoint = '/api/ingredients/';

var _deleteElement = $('#btndelete');
var _secondDeleteElement = $('#secondDelete')

// Define Modal
var _dishModalElement = $('#dishModal');
var _ingredientModalElement = $('#addIngredientModal');

//Define Table
var _dishTableElement = $('#dishTable');
var _dishIngredientEntryTableElement = _dishModalElement.find('#dishIngredientEntryTable');



// Define add Dish and ingredient button
var _dishButton = $('#addDishBtn');
var _ingredientButton = $('#addIngredientBtn');

var _DishDataTable = _dishTableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});

_dishIngredientEntryTableElement.DataTable({
    paging: false,
    searching: false
});

_ingredientButton.on('click', function(){
    openModalForIngredients({},true);
});

_dishButton.on('click', function(){
    openEditDishModal({},true);
});

_dishIngredientEntryTableElement.on('click', 'tr', function () {
    openModalForIngredients({},false);
});

_dishTableElement.on('click', 'tr', function () {
    var data = _DishDataTable.row(this).data();

    if(!data) {
        console.error('unable to retrieve data');
        return;
    }

    $.get(_restEndpoint + data.id, function(data) {
        if(!data) return;

        openEditDishModal(data, false);
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
            var option = $("<option />")
                .data('ingredient', this) // you can set a data attribute to any value in html/js, even objects references
                .text(this.ingredientName);

            dropdown.append(option);
        });
    });

    _ingredientModalElement.find('#btnIngredient')
    .off('click')
    .on('click', function(){
        var _dishIngredientListField = _ingredientModalElement.find('#ingredientDropdown');
        var _dishIngredientQuantityField = _ingredientModalElement.find('#quantity');

        var dishIngredientEntry = {
            id: null,
            ingredient: _dishIngredientListField.find('option:selected').data('ingredient'),
            quantity: _dishIngredientQuantityField.val(),
        };

        var _dishIngredientEntryTable = _dishIngredientEntryTableElement.DataTable();
        _dishIngredientEntryTable.row.add(dishIngredientEntry);
        _dishIngredientEntryTable.draw();

        _ingredientModalElement.modal('hide');

    });

    if(!newEntry){
        _ingredientModalElement.find('#secondDelete').show()
        .off('click')
        .on('click', function() {
            _dishIngredientEntryTableElement.row().remove(this);
        });
    }

    _ingredientModalElement.modal('show');

}

//Open the Dish Modal
function openEditDishModal(dish, newEntry) {
    var _nameField = _dishModalElement.find('#name');
    var _priceField = _dishModalElement.find('#price');
    var _descriptionField = _dishModalElement.find('#description');
    var _categoryField = _dishModalElement.find('#category');
    var _dishIngredientEntryDataTable = _dishIngredientEntryTableElement.DataTable();

    if(!newEntry){
        _nameField.val(dish.name);
        _priceField.val(dish.price);
        _descriptionField.val(dish.description);
        _categoryField.val(dish.category);
        _dishIngredientEntryDataTable.clear();
        _dishIngredientEntryDataTable.rows.add(dish.ingredientList);
        _dishIngredientEntryDataTable.draw();
    }else{
        _nameField.val("");
        _priceField.val("");
        _descriptionField.val("");
        _categoryField.val("");
        _dishIngredientEntryDataTable.clear().draw();
    }

    if(newEntry){
        _dishModalElement.find('#modal-title').html('New Dish')
    }else{
        _dishModalElement.find('#modal-title').html('Edit Dish');
    }

    if(!newEntry){
        _dishIngredientEntryDataTable.clear();
        _dishIngredientEntryDataTable.rows.add(dish.ingredientList);
        _dishIngredientEntryDataTable.draw();
    }

    _dishModalElement.find('#btnsubmit')
    .off('click')
    .on('click', function() {

        var saveDish = {
            name: _nameField.val(),
            price: _priceField.val(),
            description: _descriptionField.val(),
            category: _categoryField.val(),
            ingredientList: _dishIngredientEntryDataTable.rows().data().toArray(),
        };

        if(!newEntry){
            saveDish.id = dish.id
        }

        $.ajax({
            contentType : 'application/json',
            url: _restEndpoint,
            type: 'post',
            data: JSON.stringify(saveDish),
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
