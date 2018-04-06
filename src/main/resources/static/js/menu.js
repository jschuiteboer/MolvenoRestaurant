var _restEndpoint = '/api/dishes';
var _tableElementStarter = $('#starterTable');
var _tableElementMain = $('#mainTable');
var _tableElementDessert = $('#dessertTable');
var _tableElementDrinks = $('#drinksTable');
var _tableElementAlcohol = $('#alcoholTable');


// Define Modal
var _modalElement = $('#entryModal');


var _dataTable = _tableElementStarter.DataTable({
    ajax: {

        url: _restEndpoint + "/cat/Starter",
        dataSrc: "",
        type: "GET",

    },
    searching: false,
    paging: false,
});

var _dataTable = _tableElementMain.DataTable({
    ajax: {

        url: _restEndpoint + "/cat/Main",
        dataSrc: "",
        type: "GET",

    },
    searching: false,
        paging: false,
});

var _dataTable = _tableElementDessert.DataTable({
    ajax: {

        url: _restEndpoint + "/cat/Dessert",
        dataSrc: "",
        type: "GET",

    },
    searching: false,
        paging: false,
});

var _dataTable = _tableElementDrinks.DataTable({
    ajax: {

        url: _restEndpoint + "/cat/NonAlcoholicDrinks",
        dataSrc: "",
        type: "GET",

    },
    searching: false,
        paging: false,
});

var _dataTable = _tableElementAlcohol.DataTable({
    ajax: {

        url: _restEndpoint + "/cat/AlcoholicDrinks",
        dataSrc: "",
        type: "GET",

    },
    searching: false,
        paging: false,
});


function reloadData() {
    _dataTable.ajax.reload();
}