function addMessage(message)
{
    var messageResult = $.ajax({

        url : '/addMessage',
        type :'POST',
        async : false,
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : JSON.stringify(message),
        success : function (data)
        {
            console.log(messageResult);
        },
        error : function (error)
        {
            console.log(error);
        }

    });

    return messageResult;
}

function getMyMessages()
{
    var messages = [];

    $.ajax({

        url : '/getMyMessages',
        type : 'POST',
        async : false,
        success : function (data)
        {
            messages = data;
            console.log(messages);
        },
        error : function (error)
        {
            console.log(error);
        }

    });

    return messages;
}