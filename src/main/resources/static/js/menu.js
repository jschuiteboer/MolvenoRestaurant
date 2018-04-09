$(document).ready(function() {
    var _entryModal = $('#entryModal');
    var _priceContainer = _entryModal.find('#price-container');
    var _ingredientTable = _entryModal.find('#ingredientTable').DataTable({
        searching: false,
        paging: false,
    });
    var _btnAddtoOrder = _entryModal.find('#btnAddtoOrder');

    var _orderTable = $('#orderTable').DataTable({
        searching: false,
        paging: false,
    });
    var _inputComment = $('#inputComment');
    var _btnPlaceOrder = $('#btnPlaceOrder');
    var _msgContainer = $('#msg-container');

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

            _btnAddtoOrder.off('click').on('click', function() {
                _orderTable.row.add(dish);
                _orderTable.draw();
                _entryModal.modal('hide');
                _btnPlaceOrder.removeClass('hide');
            });

            _entryModal.modal('show');
        }
    });

    _btnPlaceOrder.click(function() {
        var _orderList = _orderTable.rows().data().toArray();
        var order = {
            orderList: [],
            comment: _inputComment.val(),
        };

        $.each(_orderList, function(i, dish) {
            order.orderList.push({
                id: dish.id,
            })
        });

        $.ajax({
            contentType : 'application/json',
            url: '/api/orders',
            type: 'post',
            data: JSON.stringify(order),
            success: function() {
                displayOrderMessage('Order placed', 'bg-info');
            },
        });
    });

    function displayOrderMessage(msg, cssClass) {
        var _msg = $('<p>');
        _msg.text(msg);
        _msg.addClass(cssClass);
        _msgContainer.append(_msg);
    }
});