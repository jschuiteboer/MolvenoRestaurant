var _restEndpoint = '/api/ingredients/';
var _tableElement = $('#ingredientTable');
var _addButton = $('#addButton');
var _modalElement = $('#entryModal');
var _deleteElement = $('#btndelete');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});

_addButton.on('click', function(){
    openModalForObject({},true);
});

_tableElement.on('click', 'tr', function () {
    var data = _dataTable.row(this).data();

    if(!data) {
        console.error('unable to retrieve data');
        return;
    }

    $.get(_restEndpoint + data.id, function(data) {
        if(!data) return;

        openModalForObject(data,false);
    });

});

function openModalForObject(data,newEntry) {
    var _ingredientNameField = _modalElement.find('#ingredientName');
    var _minimumStock   = _modalElement.find('#minimumStock');
    var _stockField   = _modalElement.find('#stock');
    var _priceField   = _modalElement.find('#price');
    var _unitField   = _modalElement.find('#unit');

    if(!newEntry){
        _ingredientNameField.val(data.ingredientName);
        _minimumStock.val(data.minimumStock);
        _stockField.val(data.stock);
        _priceField.val(data.price);
        _unitField.val(data.unit);
    }
    else{
            _ingredientNameField.val('');
            _minimumStock.val('');
            _stockField.val('');
            _priceField.val('');
            _unitField.val('');
    }

    if(newEntry){_modalElement.find('#modal-title').html('New Ingredient')}
    else{_modalElement.find('#modal-title').html('Edit Ingredient');}

    _modalElement.find('#btnsubmit')
        .off('click')
        .on('click', function() {

            if(newEntry){
            var saveData = {
                            ingredientName: _ingredientNameField.val(),
                            minimumStock: _minimumStock.val(),
                            stock: _stockField.val(),
                            price: _priceField.val(),
                            unit: _unitField.val()
                        };
            }
            else{
            var saveData = {
                            id: data.id,
                            ingredientName: _ingredientNameField.val(),
                            minimumStock: _minimumStock.val(),
                            stock: _stockField.val(),
                            price: _priceField.val(),
                            unit: _unitField.val()
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
        _modalElement.find('#btndelete')
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
    if(newEntry){_deleteElement.hide();}
    else{_deleteElement.show();}
}

function reloadData() {
    _dataTable.ajax.reload();
}