var slidingDelay = 350;

function showOrHideForm(form)
{
    var visible = form.is(":visible");

    if(visible)
    {
        form.slideDown(slidingDelay);
    }
    else
    {
        form.slideUp(slidingDelay, function (){form.empty();});
    }
}

function setFromInFrom(intoPlace, fromUrl, id)
{
    var queryString = fromUrl + " #"+id;

    intoPlace.load(queryString, function (){intoPlace.hide();});
}

function createQuestionHtml(questionData)
{
    var htmlString = "<p>Question:<br />"+questionData.question+"</p><br />";
    return htmlString;
}

function createMessagesListHtml(messagesListData)
{
    var htmlString = "";

    for(var i = 0;i < messagesListData.length;i ++)
    {
        htmlString = htmlString.contact(
            "<details><summary>"+messagesListData+"</summary>"+messagesListData[i].question_id.question+
            +"<p>"+messagesListData[i].message+"</p>"+
            +"</details><br />");
    }

    return htmlString;
}











