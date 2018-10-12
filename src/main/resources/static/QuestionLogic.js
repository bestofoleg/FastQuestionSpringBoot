function getQuestionStatus()
{
    var status = false;

    $.ajax({

        url : '/getQuestionStatus',
        type : 'POST',
        async : false,
        success : function (data)
        {
            status = data;
        },
        error : function (error)
        {
            console.log(error);
        }

    });

    return status;
}

function addQuestion(question)
{
    var questionResult = $.ajax({

        url : '/addQuestion',
        type :'POST',
        async : false,
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : JSON.stringify(question),
        success : function (data)
        {
            console.log(questionResult);
        },
        error : function (error)
        {
            console.log(error);
        }

    });

    return questionResult;
}

function getRandomQuestionByLanguage(lang)
{
    var result;
    var urlString = "/getRandomQuestionByLanguage?lang=" + lang;

    var questionResult = $.ajax({

        url : urlString,
        type : 'GET',
        async : false,
        contentType : 'application/json; charset=utf-8',
        success : function (data)
        {
            result = data;
            console.log(result);
        },
        error : function (error)
        {
            console.log(error);
        }

    });

    return result;
}

