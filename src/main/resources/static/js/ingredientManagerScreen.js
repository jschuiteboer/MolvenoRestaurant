var _restEndpoint = '/api/ingredients/';
var _tableElement = $('#ingredientTable');
var _addButton = $('#addButton');
var _modalElement = $('#entryModal');
var _deleteElement = $('#btndelete');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: '/api/ingredients/',
        dataSrc: "",
        type: "GET",
    },
});

_addButton.on('click', function(){
    openModalForObject({},true);
})

_tableElement.on('click', 'tr', function () {
    _tableElement.find('tr.selected').removeClass('selected');
    $(this).toggleClass('selected');

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

    if(!newEntry){
        _ingredientNameField.val(data.ingredientName);
        _minimumStock.val(data.minimumStock);
        _stockField.val(data.stock)
    }
    else{
            _ingredientNameField.val('');
            _minimumStock.val('');
            _stockField.val('');
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
                        };
            }
            else{
            var saveData = {
                            id: data.id,
                            ingredientName: _ingredientNameField.val(),
                            minimumStock: _minimumStock.val(),
                            stock: _stockField.val(),
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