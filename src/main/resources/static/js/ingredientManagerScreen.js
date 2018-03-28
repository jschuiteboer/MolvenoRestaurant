var _restEndpoint = '/api/ingredients/';
var _tableElement = $('#ingredientTable');
var _modalElement = $('#entryModal');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: '/api/ingredients/',
        dataSrc: "",
        type: "GET",
    },
});

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

        openModalForObject(data);
    });

});

function openModalForObject(data) {
    var _ingredientNameField = _modalElement.find('#ingredientName');
    var _minimumStock   = _modalElement.find('#minimumStock');
    var _stockField   = _modalElement.find('#stock');

    _ingredientNameField.val(data.ingredientName);
    _minimumStock.val(data.minimumStock);
    _stockField.val(data.stock)

    _modalElement.find('#modal-title').html('Edit Ingredient');

    _modalElement.find('#btnsubmit')
        .off('click')
        .on('click', function() {
            var saveData = {
                id: data.id,
                ingredientName: _ingredientNameField.val(),
                minimumStock: _minimumStock.val(),
                stock: _stockField.val(),
            };

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

    _modalElement.modal('show');
}

function reloadData() {
    _dataTable.ajax.reload();
}