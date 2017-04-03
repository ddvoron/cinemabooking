function makeOrder(id) {
    var arr = [];
    $('input:checkbox:checked').each(function () {
        arr.push($(this).val());
    });
    var data ='arr=' + arr;
    $.ajax({
        type: 'post',
        url: '/web/orders/' + id,
        data: data,
        dataType: 'json'
    }).done(function(data) {
        location.reload();
    }).fail(function(data) {
        $('input[type=checkbox]').prop('checked',false);
        location.reload();
    });
}

function deleteOrder(id) {
    $.ajax({
        type: 'delete',
        url: '/web/orders/' + id
    }).done(function (data) {
        $('#order' + id).hide(500);
    });
}

