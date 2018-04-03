var _restEndpoint = '/api/dishes/';
var _tableElement = $('#dishTable');
var _deleteElement = $('#btndelete');

// Define Modal
var _modalElement = $('#entryModal');

// Define add Dish button
var _dishButton = $('#addDishBtn');

var _DishDataTable = _tableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});

_modalElement.find('#ingredientTable').DataTable({
    paging: false,
});

_dishButton.on('click', function(){
    openModalForObject({},true);
});


_tableElement.on('click', 'tr', function () {
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

function openModalForObject(dish,newEntry) {
    var _nameField = _modalElement.find('#name');
    var _priceField = _modalElement.find('#price');
    var _descriptionField = _modalElement.find('#description');

    if(!newEntry){
        _nameField.val(dish.name);
        _priceField.val(dish.price);
        _descriptionField.val(dish.description);
    }else{
        _nameField.val("");
        _priceField.val("");
        _descriptionField.val("");
        var _ingredientDataTable = $('#ingredientTable').DataTable();
        _ingredientDataTable.clear().draw();
    }

    if(newEntry){
        _modalElement.find('#modal-title').html('New Dish')
    }else{
        _modalElement.find('#modal-title').html('Edit Dish');
    }

    if(!newEntry){
        var _ingredientTable = _modalElement.find('#ingredientTable').DataTable();
        _ingredientTable.clear();
        console.log(dish.ingredientList)
        _ingredientTable.rows.add(dish.ingredientList);
        _ingredientTable.draw();
    }

    _modalElement.find('#btnsubmit')
    .off('click')
    .on('click', function() {


        if(newEntry){
            var saveData = {
                name: _nameField.val(),
                price: _priceField.val(),
                description: _descriptionField.val()
            };
        }else{
            var saveData = {
                id: dish.id,
                name: _nameField.val(),
                price: _priceField.val(),
                description: _descriptionField.val()
            };
        }



        $.ajax({
            contentType : 'application/json',
            url: _restEndpoint,
            type: 'post',
            data: JSON.stringify(saveData),
            success: function() {
                _modalElement.modal('hide');
                reloadData();
            },
        });
    });

    if(!newEntry){
        _modalElement.find('#btndelete').show()
        .off('click')
        .on('click', function() {
            var result = confirm('this action can not be undone');

            if(result) {
                $.ajax({
                    contentType : 'application/json',
                    url: _restEndpoint + data.id,
                    type: 'delete',
                    success: function() {
                        _modalElement.modal('hide');
                        reloadData();
                    },
                });
            }
        });
    }
    _modalElement.modal('show');
    if(newEntry){
        _deleteElement.hide();
    }else{
        _deleteElement.show();
    }
}

function reloadData() {
    _DishDataTable.ajax.reload();
}
