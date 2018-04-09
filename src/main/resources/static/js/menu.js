$('.dish-table').each(function(i, _tableElement) {
    _tableElement = $(_tableElement);
    var endPoint = '/api/' + _tableElement.data('endpoint');

    _tableElement.DataTable({
        ajax: {
            url: endPoint,
            dataSrc: "",
            type: "GET",

        },
        searching: false,
        paging: false,
    });

    
});
