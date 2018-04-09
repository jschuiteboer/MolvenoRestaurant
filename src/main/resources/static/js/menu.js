var _entryModal = $('#entryModal');
var _priceContainer = _entryModal.find('#price-container');
var _ingredientTable = _entryModal.find('#ingredientTable').DataTable({
    searching: false,
    paging: false,
});

$('.dish-table').each(function(i, _tableElement) {
    _tableElement = $(_tableElement);
    var endPoint = '/api/' + _tableElement.data('endpoint');

    var _dishDataTable = _tableElement.DataTable({
        ajax: {
            url: endPoint,
            dataSrc: "",
            type: "GET",

        },
        searching: false,
        paging: false,
    });


    _tableElement.on('click', 'tr', function () {
        var data = _dishDataTable.row(this).data();

        openModalForDish(data);
    });

    function openModalForDish(dish) {
        _ingredientTable.clear();
        _ingredientTable.rows.add(dish.ingredientList);
        _ingredientTable.draw();

        _priceContainer.text(dish.price);

        _entryModal.modal('show');
    }
});
