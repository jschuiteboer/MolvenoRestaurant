var _restEndpoint = '/api/dishes/';
    var _tableElement = $('#dishTable');

    // Table Modal
    var _modalElement = $('#entryModal');

    // AddDish Modal
    var _addDishModal = $('#addDishModal');
    var _dishButton = $('#addDishBtn');

    var _dataTable = _tableElement.DataTable({
        ajax: {
            url: _restEndpoint,
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
        var _nameField = _modalElement.find('#name');
        var _priceField = _modalElement.find('#price');
        var _descriptionField = _modalElement.find('#description');

        _nameField.val(data.name);
        _priceField.val(data.price);
        _descriptionField.val(data.description);

        _modalElement.find('#modal-title').html('Edit Ingredient');

        _modalElement.find('#btnsubmit')
        .off('click')
        .on('click', function() {
            var saveData = {

                name: _nameField.val(),
                price: _priceField.val(),
                description: _descriptionField.val()
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