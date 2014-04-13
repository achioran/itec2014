modules = {
    application {
        resource url:'js/application.js'
    }
    jqueryui {
        resource url:'http://code.jquery.com/ui/1.10.2/jquery-ui.js'
        resource url:'http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.0/themes/smoothness/jquery-ui.css', attrs: [rel: "stylesheet", type: "css"]
    }

    styles{
        resource url:'css/contents.css'
    }

}