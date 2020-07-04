$(document).ready( function () {
    var table = $('#centrosTable').DataTable({
        
           "sAjaxSource": "/centros",
           "sAjaxDataProp": "",
           "order": [[ 0, "asc" ]],
           "aoColumns": [
                { "mData": "idcen"},
                { "mData": "nombrecen" },
                { "mData": "descripcioncen" },
                { "mData": "estadocen" },
                { "mData": "municipiocen" }           ]
    })
});