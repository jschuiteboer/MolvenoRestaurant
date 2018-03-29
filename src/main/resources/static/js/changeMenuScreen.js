var _restEndpoint = '/api/dishes/';
var _tableElement = $('#dishTable');
var _deleteElement = $('#btndelete');

// Define Modal
var _modalElement = $('#entryModal');

// Define add Dish button
var _dishButton = $('#addDishBtn');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});


_dishButton.on('click', function(){
    openModalForObject({},true);
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

        openModalForObject(data, false);
    });
});

function openModalForObject(data,newEntry) {
    var _nameField = _modalElement.find('#name');
    var _priceField = _modalElement.find('#price');
    var _descriptionField = _modalElement.find('#description');

    if(!newEntry){
        _nameField.val(data.name);
        _priceField.val(data.price);
        _descriptionField.val(data.description);
    }else{
        _nameField.val("");
        _priceField.val("");
        _descriptionField.val("");
    }

    if(newEntry){
        _modalElement.find('#modal-title').html('New Dish')
    }else{
        _modalElement.find('#modal-title').html('Edit Dish');
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
                id: data.id,
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
    _dataTable.ajax.reload();
}
